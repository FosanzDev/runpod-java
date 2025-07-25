package com.fosanzdev.runpodjava.operations.queries.pod;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.graphql.GraphQLQueryBuilder;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
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
     *
     * Behavior by fallback strategy:
     * - STRICT: Uses complete query, fails if it doesn't work
     * - AUTO: Uses complete query, falls back to minimal query on server errors
     *
     * @param input Optional filter parameters
     * @return The pod information
     * @throws RunPodRuntimeException if the query fails
     */
    public Pod getPod(PodFilter input) {
        try {
            Map<String, Object> variables = new HashMap<>();
            if (input != null) {
                variables.put("input", input);
            }

            // Build primary query (all fields)
            String primaryQuery = GraphQLQueryBuilder.buildQueryWithVariables(
                    Pod.class, "pod", "pod", "$input: PodFilter");

            // Build fallback query (only essential fields - priority 0)
            List<String> excludableFields = GraphQLQueryBuilder.getFallbackExclusionList(Pod.class);
            Set<String> excludedFields = new HashSet<>(excludableFields);
            String fallbackQuery = GraphQLQueryBuilder.buildQueryWithVariables(
                    Pod.class, "pod", "pod", "$input: PodFilter", excludedFields);

            PodResponse response = executeWithFallback(
                    primaryQuery,
                    fallbackQuery,
                    variables,
                    PodResponse.class,
                    "getPod"
            );

            return response.getPod();

        } catch (IOException e) {
            throw new RunPodRuntimeException("Failed to retrieve pod", e);
        }
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