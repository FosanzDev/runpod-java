package com.fosanzdev.runpodjava.internal;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodClientConfig;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.graphql.GraphQLException;

import java.io.IOException;
import java.util.Map;

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
     * Execute with fallback based on the configured strategy.
     *
     * @param primaryQuery The complete query with all fields
     * @param fallbackQuery The minimal query with only essential fields
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
            Map<String, Object> variables,
            Class<T> responseType,
            String operation) throws IOException {

        RunPodClientConfig.FallbackStrategy strategy = client.getConfig().getFallbackStrategy();
        boolean shouldLog = client.getConfig().shouldLogFallbacks();

        return switch (strategy) {
            case STRICT -> {
                // Only try the primary query
                if (shouldLog) {
                    FallbackLogger.logFallback(operation, "STRICT mode - using complete query", "no fallback", shouldLog);
                }
                yield execute(primaryQuery, variables, responseType);
            }
            case AUTO -> {
                // Try primary first, then fallback on server errors
                try {
                    yield execute(primaryQuery, variables, responseType);
                } catch (GraphQLException primaryError) {
                    if (primaryError.isServerInternalError()) {
                        if (shouldLog) {
                            FallbackLogger.logFallback(operation,
                                    "Server error in primary query: " + primaryError.getMessage(),
                                    "trying minimal query", shouldLog);
                        }

                        try {
                            yield execute(fallbackQuery, variables, responseType);
                        } catch (IOException fallbackError) {
                            throw new RunPodRuntimeException(
                                    "Both primary and fallback queries failed. Primary: " + primaryError.getMessage() +
                                            ", Fallback: " + fallbackError.getMessage(), primaryError);
                        }
                    }
                    // Primary error is not a server error, re-throw it
                    throw primaryError;
                }
            }
        };
    }
}