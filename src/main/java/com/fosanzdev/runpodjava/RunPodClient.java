package com.fosanzdev.runpodjava;

import com.fosanzdev.runpodjava.RunPodClientConfig;
import com.fosanzdev.runpodjava.graphql.GraphQLException;
import com.fosanzdev.runpodjava.graphql.GraphQLRequest;
import com.fosanzdev.runpodjava.graphql.GraphQLResponse;
import com.fosanzdev.runpodjava.operations.queries.Queries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * RunPod GraphQL API Client with intelligent fallback mechanisms.
 * <p>
 * This client automatically handles server-side API issues by falling back to
 * simpler queries when complete queries fail.
 *
 * @author FosanzDev
 * @version 0.1
 */
public class RunPodClient {
    private static final String RUNPOD_ENDPOINT = "https://api.runpod.io/graphql";
    private final String apiKey;
    private final OkHttpClient client;
    private final RunPodClientConfig config;
    private final Gson gson;

    // Public operation instances for direct access
    public final Queries queries;

    public RunPodClient(String apiKey) {
        this(apiKey, RunPodClientConfig.defaultConfig());
    }

    public RunPodClient(String apiKey, RunPodClientConfig config) {
        this.apiKey = apiKey;
        this.config = config;
        this.client = new OkHttpClient.Builder().build();

        // Configure Gson with LocalDateTime adapter to avoid reflection issues
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        // Initialize operations
        this.queries = new Queries(this);
    }

    public RunPodClientConfig getConfig() {
        return config;
    }

    // Core HTTP execution method (package-private so services can use it)
    public <T> T execute(String query, Map<String, Object> variables, Class<T> responseType) throws IOException {
        GraphQLRequest graphQLRequest = new GraphQLRequest(query, variables);

        RequestBody body = RequestBody.create(
                graphQLRequest.toJson(),
                MediaType.parse("application/json")
        );

        Request request = createRequestBuilder()
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP " + response.code() + ": " + response.body().string());
            }

            if (response.body() == null) {
                throw new IOException("Empty response body");
            }

            String responseBody = response.body().string();

            Type wrappedType = TypeToken.getParameterized(GraphQLResponse.class, responseType).getType();
            GraphQLResponse<T> graphQLResponse = gson.fromJson(responseBody, wrappedType);

            if (graphQLResponse.getErrors() != null && !graphQLResponse.getErrors().isEmpty()) {
                String errorMessages = graphQLResponse.getErrors().stream()
                        .map(error -> error.getMessage() != null ? error.getMessage() : error.toString())
                        .collect(Collectors.joining(", "));

                throw new GraphQLException("GraphQL errors: " + errorMessages, graphQLResponse.getErrors());
            }

            return graphQLResponse.getData();
        }
    }

    private Request.Builder createRequestBuilder() {
        return new Request.Builder()
                .url(RUNPOD_ENDPOINT)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json");
    }

    /**
     * Custom TypeAdapter for LocalDateTime to handle JSON serialization/deserialization
     * without using reflection on internal fields.
     */
    private static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        private static final DateTimeFormatter[] FALLBACK_FORMATTERS = {
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
                DateTimeFormatter.ISO_OFFSET_DATE_TIME
        };

        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.format(ISO_FORMATTER));
            }
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
                in.nextNull();
                return null;
            }

            String dateString = in.nextString();

            // Try ISO format first
            try {
                return LocalDateTime.parse(dateString, ISO_FORMATTER);
            } catch (DateTimeParseException e) {
                // Try fallback formats
                for (DateTimeFormatter formatter : FALLBACK_FORMATTERS) {
                    try {
                        return LocalDateTime.parse(dateString, formatter);
                    } catch (DateTimeParseException ignored) {
                        // Continue to next formatter
                    }
                }

                // If all formatters fail, throw exception with helpful message
                throw new IOException("Unable to parse LocalDateTime: " + dateString +
                        ". Expected ISO format or common variants.", e);
            }
        }
    }
}