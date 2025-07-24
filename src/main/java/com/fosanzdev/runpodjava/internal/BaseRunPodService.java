package com.fosanzdev.runpodjava.internal;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodClientConfig;
import com.fosanzdev.runpodjava.RunPodException;
import com.fosanzdev.runpodjava.graphql.GraphQLException;

import java.io.IOException;
import java.util.Map;

import static com.fosanzdev.runpodjava.RunPodClientConfig.FallbackStrategy.CONSERVATIVE;
import static com.fosanzdev.runpodjava.RunPodClientConfig.FallbackStrategy.STRICT;

/**
 * Base class for all RunPod service operations.
 * Provides common functionality including intelligent fallback mechanisms.
 */
public abstract class BaseRunPodService {
    protected final RunPodClient client;

    protected BaseRunPodService(RunPodClient client) {
        this.client = client;
    }

    protected <T> T execute(String query, Map<String, Object> variables, Class<T> responseType) throws IOException {
        return client.execute(query, variables, responseType);
    }

    /**
     * Execute with multi-level fallback based on the configured strategy.
     *
     * @param primaryQuery The complete query with all fields
     * @param fallbackQuery The partial query without problematic fields
     * @param minimalQuery The basic query with only essential fields
     * @param variables Query variables
     * @param responseType Response type class
     * @param operation Operation name for logging
     * @param <T> Response type
     * @return Query result
     * @throws IOException If queries fail according to the strategy
     */
    protected <T> T executeWithFallback(
            String primaryQuery,
            String fallbackQuery,
            String minimalQuery,
            Map<String, Object> variables,
            Class<T> responseType,
            String operation) throws IOException {

        RunPodClientConfig.FallbackStrategy strategy = client.getConfig().getFallbackStrategy();
        boolean shouldLog = client.getConfig().shouldLogFallbacks();

        return switch (strategy) {
            case STRICT ->
                // Only try the primary query
                    execute(primaryQuery, variables, responseType);
            case CONSERVATIVE -> {
                // Only use the minimal query
                FallbackLogger.logFallback(operation, "Conservative strategy - using minimal query", "minimal", shouldLog);
                yield execute(minimalQuery, variables, responseType);
            }
            default ->
                // Try primary → fallback → minimal
                    executeAutoFallback(primaryQuery, fallbackQuery, minimalQuery,
                            variables, responseType, operation, shouldLog);
        };
    }

    private <T> T executeAutoFallback(
            String primaryQuery,
            String fallbackQuery,
            String minimalQuery,
            Map<String, Object> variables,
            Class<T> responseType,
            String operation,
            boolean shouldLog) throws IOException {

        // Try primary query
        try {
            return execute(primaryQuery, variables, responseType);
        } catch (GraphQLException primaryError) {
            if (primaryError.isServerInternalError()) {
                FallbackLogger.logFallback(operation,
                        "Server error in primary query: " + primaryError.getMessage(),
                        "fallback", shouldLog);

                // Try fallback query
                try {
                    return execute(fallbackQuery, variables, responseType);
                } catch (GraphQLException fallbackError) {
                    if (fallbackError.isServerInternalError()) {
                        FallbackLogger.logFallback(operation,
                                "Server error in fallback query: " + fallbackError.getMessage(),
                                "minimal", shouldLog);

                        // Try minimal query as last resort
                        try {
                            return execute(minimalQuery, variables, responseType);
                        } catch (IOException minimalError) {
                            throw new RunPodException(
                                    "All query levels failed. Primary: " + primaryError.getMessage() +
                                            ", Fallback: " + fallbackError.getMessage() +
                                            ", Minimal: " + minimalError.getMessage(), primaryError);
                        }
                    }
                    // Fallback error is not a server error, re-throw it
                    throw fallbackError;
                }
            }
            // Primary error is not a server error, re-throw it
            throw primaryError;
        }
    }
}