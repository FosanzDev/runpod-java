package com.fosanzdev.runpodjava.operations.queries.gpu;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodClientConfig;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.graphql.GraphQLException;
import com.fosanzdev.runpodjava.graphql.GraphQLQueryBuilder;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.internal.FallbackLogger;
import com.fosanzdev.runpodjava.types.GpuType;

import java.io.IOException;
import java.util.*;

/**
 * GPU-related queries for the RunPod API with intelligent progressive fallback.
 * Automatically removes problematic fields when server errors occur.
 */
public class GpuQueries extends BaseRunPodService {

    public GpuQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Get all GPU types with intelligent fallback handling.
     */
    public List<GpuType> getGpuTypes() {
        return getGpuTypes(null);
    }

    /**
     * Get GPU types with filter and intelligent progressive fallback.
     *
     * Behavior by fallback strategy:
     * - STRICT: Uses complete query, fails if it doesn't work
     * - AUTO: Progressively removes problematic fields until it works
     * - CONSERVATIVE: Uses minimal query for maximum reliability
     */
    public List<GpuType> getGpuTypes(GpuTypeFilter input) {
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
            throw new RunPodRuntimeException("Failed to retrieve GPU types", e);
        }
    }

    /**
     * STRICT mode: Use complete query or fail.
     */
    private List<GpuType> executeStrict(Map<String, Object> variables) throws IOException {
        String query = GraphQLQueryBuilder.buildQueryWithVariables(
                GpuType.class, "gpuTypes", "gpuTypes", "$input: GpuTypeFilter"
        );

        GpuTypesResponse response = execute(query, variables, GpuTypesResponse.class);
        return response.getGpuTypes();
    }

    /**
     * AUTO mode: Progressive fallback by excluding problematic fields one by one.
     */
    private List<GpuType> executeWithProgressiveFallback(Map<String, Object> variables) throws IOException {
        List<String> excludableFields = GraphQLQueryBuilder.getFallbackExclusionList(GpuType.class);
        Set<String> excludedFields = new HashSet<>();

        // Try complete query first
        try {
            String query = GraphQLQueryBuilder.buildQueryWithVariables(
                    GpuType.class, "gpuTypes", "gpuTypes", "$input: GpuTypeFilter", excludedFields
            );

            GpuTypesResponse response = execute(query, variables, GpuTypesResponse.class);
            return response.getGpuTypes();

        } catch (GraphQLException e) {
            if (!e.isServerInternalError()) {
                throw e; // Not a server error we can handle with fallback
            }

            if (client.getConfig().shouldLogFallbacks()) {
                FallbackLogger.logFallback("getGpuTypes", "Server internal error",
                        "trying progressive field exclusion", true);
            }
        }

        // Progressive fallback: exclude fields one by one until it works
        for (String fieldToExclude : excludableFields) {
            excludedFields.add(fieldToExclude);

            try {
                String query = GraphQLQueryBuilder.buildQueryWithVariables(
                        GpuType.class, "gpuTypes", "gpuTypes", "$input: GpuTypeFilter", excludedFields
                );

                if (client.getConfig().shouldLogFallbacks()) {
                    FallbackLogger.logFieldMissing("getGpuTypes", fieldToExclude, true);
                }

                GpuTypesResponse response = execute(query, variables, GpuTypesResponse.class);

                if (client.getConfig().shouldLogFallbacks()) {
                    FallbackLogger.logFallback("getGpuTypes", "Progressive fallback successful",
                            "excluded " + excludedFields.size() + " problematic fields", true);
                }

                return response.getGpuTypes();

            } catch (GraphQLException e) {
                if (!e.isServerInternalError()) {
                    throw e; // Not a server error we can handle
                }
                // Continue to next exclusion
            }
        }

        // If we get here, even the minimal query failed
        throw new RunPodRuntimeException("All fallback attempts failed, including minimal query");
    }
}