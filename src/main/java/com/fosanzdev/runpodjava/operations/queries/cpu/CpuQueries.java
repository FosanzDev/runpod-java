package com.fosanzdev.runpodjava.operations.queries.cpu;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.graphql.GraphQLQueryBuilder;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.types.CpuType;

import java.io.IOException;
import java.util.*;

/**
 * CPU-related queries for the RunPod API with intelligent fallback.
 */
public class CpuQueries extends BaseRunPodService {

    public CpuQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Get all available CPU types with intelligent fallback handling.
     *
     * Behavior by fallback strategy:
     * - STRICT: Uses complete query, fails if it doesn't work
     * - AUTO: Uses complete query, falls back to minimal query on server errors
     *
     * @return List of CPU types
     * @throws RunPodRuntimeException if the query fails
     */
    public List<CpuType> getCpuTypes() {
        try {
            Map<String, Object> variables = new HashMap<>();

            // Build primary query (all fields)
            String primaryQuery = GraphQLQueryBuilder.buildQuery(CpuType.class, "cpuTypes", "cpuTypes");

            // Build fallback query (only essential fields - priority 0)
            List<String> excludableFields = GraphQLQueryBuilder.getFallbackExclusionList(CpuType.class);
            Set<String> excludedFields = new HashSet<>(excludableFields);
            String fallbackQuery = GraphQLQueryBuilder.buildQuery(CpuType.class, "cpuTypes", "cpuTypes", excludedFields);

            CpuTypesResponse response = executeWithFallback(
                    primaryQuery,
                    fallbackQuery,
                    variables,
                    CpuTypesResponse.class,
                    "getCpuTypes"
            );

            return response.getCpuTypes();

        } catch (IOException e) {
            throw new RunPodRuntimeException("Failed to retrieve CPU types", e);
        }
    }
}