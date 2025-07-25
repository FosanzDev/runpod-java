package com.fosanzdev.runpodjava.operations.queries.pod;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.types.Pod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PodQueries extends BaseRunPodService {

    public PodQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Query a single pod with optional filtering and intelligent fallback handling.
     *
     * @param input Optional filter parameters
     * @return The pod information
     */
    public Pod getPod(PodFilter input) {
        try {
            String primaryQuery = buildCompleteQuery();
            String fallbackQuery = buildFallbackQuery();
            String minimalQuery = buildMinimalQuery();

            Map<String, Object> variables = new HashMap<>();
            if (input != null) {
                variables.put("input", input);
            }

            return executeWithFallback(
                    primaryQuery, fallbackQuery, minimalQuery,
                    variables, PodResponse.class, "getPod"
            ).getPod();
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

    /**
     * Get basic pod information for maximum reliability.
     * This method uses only the most stable fields and should always work.
     *
     * @return Pod with basic information
     */
    public Pod getPodBasic(PodFilter input) {
        try {
            Map<String, Object> variables = new HashMap<>();
            if (input != null) {
                variables.put("input", input);
            }

            PodResponse response = execute(buildMinimalQuery(), variables, PodResponse.class);
            return response.getPod();
        } catch (IOException e) {
            throw new RunPodRuntimeException("Failed to retrieve basic pod information", e);
        }
    }

    public Pod getPodBasic() {
        return getPodBasic(null);
    }

    // Complete query with all fields (might fail on server issues)
    private String buildCompleteQuery() {
        return """
            query pod($input: PodFilter) {
              pod(input: $input) {
                id
                name
                desiredStatus
                imageName
                containerDiskInGb
                memoryInGb
                vcpuCount
                gpuCount
                costPerHr
                createdAt
                podType
                port
                ports
                env
                dockerArgs
                volumeInGb
                volumeMountPath
                templateId
                machineId
                lastStatusChange
                uptimeSeconds
                locked
                runtime {
                  container {
                    cpuPercent
                    memoryPercent
                  }
                  gpus {
                    id
                    gpuUtilPercent
                    memoryUtilPercent
                  }
                  ports {
                    ip
                    isIpPublic
                    privatePort
                    publicPort
                    type
                  }
                  uptimeInSeconds
                }
                machine {
                  id
                  gpuDisplayName
                  gpuTypeId
                  location
                  machineType
                  costPerHr
                  currentPricePerGpu
                  gpuType {
                    id
                    displayName
                    manufacturer
                    memoryInGb
                    cudaCores
                  }
                }
              }
            }
            """;
    }

    // Fallback query with moderate complexity
    private String buildFallbackQuery() {
        return """
            query pod($input: PodFilter) {
              pod(input: $input) {
                id
                name
                desiredStatus
                imageName
                containerDiskInGb
                memoryInGb
                vcpuCount
                gpuCount
                costPerHr
                createdAt
                podType
                port
                ports
                env
                volumeInGb
                volumeMountPath
                templateId
                machineId
                lastStatusChange
                uptimeSeconds
                runtime {
                  uptimeInSeconds
                }
                machine {
                  id
                  gpuDisplayName
                  location
                  costPerHr
                }
              }
            }
            """;
    }

    // Minimal query with only essential fields
    private String buildMinimalQuery() {
        return """
            query pod($input: PodFilter) {
              pod(input: $input) {
                id
                name
                desiredStatus
                imageName
                containerDiskInGb
                memoryInGb
                vcpuCount
                gpuCount
                costPerHr
                createdAt
                podType
                machineId
              }
            }
            """;
    }
}