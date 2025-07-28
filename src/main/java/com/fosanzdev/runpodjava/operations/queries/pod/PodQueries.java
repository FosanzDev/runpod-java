package com.fosanzdev.runpodjava.operations.queries.pod;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodClientConfig;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.graphql.GraphQLException;
import com.fosanzdev.runpodjava.graphql.GraphQLQueryBuilder;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.internal.FallbackLogger;
import com.fosanzdev.runpodjava.types.Pod;

import java.io.IOException;
import java.util.*;

/**
 * Pod-related queries for the RunPod API with intelligent fallback.
 */
public class PodQueries extends BaseRunPodService {

    public PodQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Query a single pod with optional filtering and intelligent fallback handling.
     * <p>
     * Behavior by fallback strategy:
     * - STRICT: Uses complete query, fails if it doesn't work
     * - AUTO: Uses complete query, falls back to minimal query on server errors
     *
     * @param input Optional filter parameters
     * @return The pod information
     * @throws RunPodRuntimeException if the query fails
     */
    public Pod getPod(PodFilter input) {
        RunPodClientConfig.FallbackStrategy strategy = client.getConfig().getFallbackStrategy();

        try {
            Map<String, Object> variables = new HashMap<>();
            if (input != null) {
                variables.put("input", input);
            }

            switch (strategy) {
                case STRICT:
                    return executeStrict(variables);

                case AUTO:
                default:
                    return executeWithProgressiveFallback(variables);
            }

        } catch (IOException e) {
            throw new RunPodRuntimeException("Failed to retrieve pod", e);
        }
    }

    private Pod executeStrict(Map<String, Object> variables) throws IOException {
        String query = GraphQLQueryBuilder.buildQueryWithVariables(
                Pod.class, "pod", "pod", "$input: PodFilter", new HashSet<>(), 3, 10);

        PodResponse response = execute(query, variables, PodResponse.class);
        return response.getPod();
    }

    private Pod executeWithProgressiveFallback(Map<String, Object> variables) throws IOException {
        Set<String> excludedFields = new HashSet<>();

        try {
            // Start with fallbackThreshold = 10 to include all fields
            String query = GraphQLQueryBuilder.buildQueryWithVariables(
                    Pod.class, "pod", "pod", "$input: PodFilter", excludedFields, 3, 10
            );

            System.out.println(query);

            PodResponse response = execute(query, variables, PodResponse.class);
            return response.getPod();
        } catch (Exception e) { // Catch all exceptions, not just GraphQLException
            // Check if it's a server error by looking at the message or exception type
            boolean isServerError = e instanceof GraphQLException
                    ? ((GraphQLException) e).isServerInternalError()
                    : e.getMessage().contains("Server internal error") ||
                    e.getMessage().contains("HTTP 500") ||
                    e.getMessage().contains("internal error");

            if (!isServerError && e instanceof GraphQLException) {
                throw (GraphQLException) e; // Re-throw non-server GraphQL errors
            }

            if (client.getConfig().shouldLogFallbacks()) {
                FallbackLogger.logFallback("getPod", "Server error: " + e.getMessage(),
                        "trying progressive field exclusion", true);
            }
        }

        // Progressive fallback by priority
        int[] fallbackThresholds = {8, 5, 1, 0}; // Try excluding 8+, then 5+, then 1+, finally only essential

        for (int threshold : fallbackThresholds) {
            try {
                String query = GraphQLQueryBuilder.buildQueryWithVariables(
                        Pod.class, "pod", "pod", "$input: PodFilter", excludedFields, 2, threshold
                );

                if (client.getConfig().shouldLogFallbacks()) {
                    FallbackLogger.logFallback("getPod", "Trying fallback with threshold " + threshold,
                            "excluding fields with priority > " + threshold, true);
                }

                PodResponse response = execute(query, variables, PodResponse.class);

                if (client.getConfig().shouldLogFallbacks()) {
                    FallbackLogger.logFallback("getPod", "Progressive fallback successful",
                            "using priority threshold " + threshold, true);
                }

                return response.getPod();

            } catch (Exception e) {
                // Continue to next fallback level
                if (client.getConfig().shouldLogFallbacks()) {
                    FallbackLogger.logFallback("getPod", "Threshold " + threshold + " failed: " + e.getMessage(),
                            "trying next fallback level", true);
                }
            }
        }

        throw new RunPodRuntimeException("All fallback attempts failed, including minimal query");
    }


    /**
     * Query a single pod without filtering.
     *
     * @return The pod information
     */
    public Pod getPod() {
        return getPod(null);
    }
}