package com.fosanzdev.runpodjava.operations.queries.gpu;

import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.types.GpuType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GPU-related queries for the RunPod API.
 * <p>
 * This class implements intelligent fallback mechanisms to ensure maximum reliability:
 * - Primary queries include all available fields (including lowestPrice, nodeGroupDatacenters, etc.)
 * - Fallback queries exclude problematic fields that may cause server errors
 * - Minimal queries include only essential fields for maximum compatibility
 * <p>
 * Fallback behavior can be configured via com.fosanzdev.runpodjava.RunPodClientConfig:
 * - AUTO (default): Try complete query, fall back automatically on server errors
 * - STRICT: Only use complete queries, fail if they don't work
 * - CONSERVATIVE: Always use basic queries for maximum reliability
 *
 * @see com.fosanzdev.runpodjava.RunPodClientConfig.FallbackStrategy
 */
public class GpuQueries extends BaseRunPodService {

    public GpuQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Get all GPU types with intelligent fallback handling.
     * <p>
     * This method will attempt to retrieve complete GPU information including:
     * - Basic GPU specs (id, displayName, manufacturer, memory, cores)
     * - Pricing information (all price fields)
     * - Availability data (lowestPrice) - may be unavailable due to server issues
     * - Datacenter information (nodeGroupDatacenters) - may be simplified on fallback
     *
     * @return List of GPU types with available information
     * @throws IOException If all query attempts fail
     */
    public List<GpuType> getGpuTypes() throws IOException {
        return getGpuTypes(null);
    }

    /**
     * Get GPU types with filter and intelligent fallback handling.
     *
     * @param input Filter criteria for GPU types
     * @return List of filtered GPU types with available information
     * @throws IOException If all query attempts fail
     */
    public List<GpuType> getGpuTypes(GpuTypeFilter input) throws IOException {
        String primaryQuery = buildCompleteGpuQuery();
        String fallbackQuery = buildFallbackGpuQuery();
        String minimalQuery = buildMinimalGpuQuery();

        Map<String, Object> variables = new HashMap<>();
        if (input != null) {
            variables.put("input", input);
        }

        return executeWithFallback(
                primaryQuery, fallbackQuery, minimalQuery,
                variables, GpuTypesResponse.class, "getGpuTypes"
        ).getGpuTypes();
    }

    /**
     * Force retrieval of complete GPU information without fallbacks.
     * Use this method when you specifically need all fields including lowestPrice.
     * Will throw an exception if the complete query fails.
     *
     * @return List of GPU types with complete information
     * @throws IOException If the complete query fails
     */
    public List<GpuType> getGpuTypesComplete() throws IOException {
        return getGpuTypesComplete(null);
    }

    /**
     * Force retrieval of complete GPU information with filter, without fallbacks.
     *
     * @param input Filter criteria for GPU types
     * @return List of GPU types with complete information
     * @throws IOException If the complete query fails
     */
    public List<GpuType> getGpuTypesComplete(GpuTypeFilter input) throws IOException {
        Map<String, Object> variables = new HashMap<>();
        if (input != null) {
            variables.put("input", input);
        }

        GpuTypesResponse response = execute(buildCompleteGpuQuery(), variables, GpuTypesResponse.class);
        return response.getGpuTypes();
    }

    /**
     * Get basic GPU information for maximum reliability.
     * This method uses only the most stable fields and should always work.
     *
     * @return List of GPU types with basic information
     * @throws IOException If even the basic query fails
     */
    public List<GpuType> getGpuTypesBasic() throws IOException {
        GpuTypesResponse response = execute(buildMinimalGpuQuery(), null, GpuTypesResponse.class);
        return response.getGpuTypes();
    }

    // Query builders for different levels of completeness

    private String buildCompleteGpuQuery() {
        return """
            query gpuTypes($input: GpuTypeFilter) {
              gpuTypes(input: $input) {
                lowestPrice {
                  gpuName
                  gpuTypeId
                  minimumBidPrice
                  uninterruptablePrice
                  minMemory
                  minVcpu
                  rentalPercentage
                  rentedCount
                  totalCount
                  stockStatus
                  minDownload
                  minDisk
                  minUpload
                  countryCode
                  supportPublicIp
                  compliance
                  maxGpuCount
                  maxUnreservedGpuCount
                  availableGpuCounts
                }
                maxGpuCount
                maxGpuCountCommunityCloud
                maxGpuCountSecureCloud
                minPodGpuCount
                nodeGroupGpuSizes
                nodeGroupDatacenters {
                  id
                  name
                  location
                  storage {
                    hostname
                    ips
                    pw
                    type
                    user
                    list {
                      mnt
                      pw
                      servers
                      type
                      versions
                      primary
                    }
                  }
                  globalNetwork
                  storageSupport
                  listed
                  gpuAvailability {
                    available
                    stockStatus
                    gpuTypeId
                    gpuTypeDisplayName
                    displayName
                    id
                  }
                  compliance
                }
                id
                displayName
                manufacturer
                memoryInGb
                cudaCores
                secureCloud
                communityCloud
                securePrice
                clusterPrice
                communityPrice
                oneMonthPrice
                threeMonthPrice
                sixMonthPrice
                oneWeekPrice
                communitySpotPrice
                secureSpotPrice
                throughput
              }
            }
            """;
    }

    private String buildFallbackGpuQuery() {
        return """
            query gpuTypes($input: GpuTypeFilter) {
              gpuTypes(input: $input) {
                maxGpuCount
                maxGpuCountCommunityCloud
                maxGpuCountSecureCloud
                minPodGpuCount
                nodeGroupGpuSizes
                nodeGroupDatacenters {
                  id
                  name
                  location
                  globalNetwork
                  storageSupport
                  listed
                  compliance
                  gpuAvailability {
                    available
                    stockStatus
                    gpuTypeId
                    gpuTypeDisplayName
                    displayName
                    id
                  }
                }
                id
                displayName
                manufacturer
                memoryInGb
                cudaCores
                secureCloud
                communityCloud
                securePrice
                clusterPrice
                communityPrice
                oneMonthPrice
                threeMonthPrice
                sixMonthPrice
                oneWeekPrice
                communitySpotPrice
                secureSpotPrice
                throughput
              }
            }
            """;
    }

    private String buildMinimalGpuQuery() {
        return """
            query gpuTypes($input: GpuTypeFilter) {
              gpuTypes(input: $input) {
                id
                displayName
                manufacturer
                memoryInGb
                cudaCores
                secureCloud
                communityCloud
                securePrice
                communityPrice
                maxGpuCount
              }
            }
            """;
    }
}