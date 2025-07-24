package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.operations.queries.gpu.GpuQueries;

import java.util.List;

/**
 * GPU type information from RunPod API.
 * <p>
 * Note: Some fields may be null when using fallback queries that exclude
 * problematic fields. Always check for null values before using numeric fields.
 *
 * @see GpuQueries for information about fallback behavior
 */
public class GpuType {
    private LowestPrice lowestPrice;
    private Integer maxGpuCount;
    private Integer maxGpuCountCommunityCloud;
    private Integer maxGpuCountSecureCloud;
    private Integer minPodGpuCount;
    private List<Integer> nodeGroupGpuSizes;
    private List<DataCenter> nodeGroupDatacenters;
    private String id;
    private String displayName;
    private String manufacturer;
    private Integer memoryInGb;
    private Integer cudaCores;
    private Boolean secureCloud;
    private Boolean communityCloud;
    private Double securePrice;
    private Double clusterPrice;
    private Double communityPrice;
    private Double oneMonthPrice;
    private Double threeMonthPrice;
    private Double sixMonthPrice;
    private Double oneWeekPrice;
    private Double communitySpotPrice;
    private Double secureSpotPrice;
    private Integer throughput;

    // Getters and Setters
    public LowestPrice getLowestPrice() { return lowestPrice; }
    public void setLowestPrice(LowestPrice lowestPrice) { this.lowestPrice = lowestPrice; }

    public Integer getMaxGpuCount() { return maxGpuCount; }
    public void setMaxGpuCount(Integer maxGpuCount) { this.maxGpuCount = maxGpuCount; }

    public Integer getMaxGpuCountCommunityCloud() { return maxGpuCountCommunityCloud; }
    public void setMaxGpuCountCommunityCloud(Integer maxGpuCountCommunityCloud) { this.maxGpuCountCommunityCloud = maxGpuCountCommunityCloud; }

    public Integer getMaxGpuCountSecureCloud() { return maxGpuCountSecureCloud; }
    public void setMaxGpuCountSecureCloud(Integer maxGpuCountSecureCloud) { this.maxGpuCountSecureCloud = maxGpuCountSecureCloud; }

    public Integer getMinPodGpuCount() { return minPodGpuCount; }
    public void setMinPodGpuCount(Integer minPodGpuCount) { this.minPodGpuCount = minPodGpuCount; }

    public List<Integer> getNodeGroupGpuSizes() { return nodeGroupGpuSizes; }
    public void setNodeGroupGpuSizes(List<Integer> nodeGroupGpuSizes) { this.nodeGroupGpuSizes = nodeGroupGpuSizes; }

    public List<DataCenter> getNodeGroupDatacenters() { return nodeGroupDatacenters; }
    public void setNodeGroupDatacenters(List<DataCenter> nodeGroupDatacenters) { this.nodeGroupDatacenters = nodeGroupDatacenters; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Integer getMemoryInGb() { return memoryInGb; }
    public void setMemoryInGb(Integer memoryInGb) { this.memoryInGb = memoryInGb; }

    public Integer getCudaCores() { return cudaCores; }
    public void setCudaCores(Integer cudaCores) { this.cudaCores = cudaCores; }

    public Boolean getSecureCloud() { return secureCloud; }
    public void setSecureCloud(Boolean secureCloud) { this.secureCloud = secureCloud; }

    public Boolean getCommunityCloud() { return communityCloud; }
    public void setCommunityCloud(Boolean communityCloud) { this.communityCloud = communityCloud; }

    public Double getSecurePrice() { return securePrice; }
    public void setSecurePrice(Double securePrice) { this.securePrice = securePrice; }

    public Double getClusterPrice() { return clusterPrice; }
    public void setClusterPrice(Double clusterPrice) { this.clusterPrice = clusterPrice; }

    public Double getCommunityPrice() { return communityPrice; }
    public void setCommunityPrice(Double communityPrice) { this.communityPrice = communityPrice; }

    public Double getOneMonthPrice() { return oneMonthPrice; }
    public void setOneMonthPrice(Double oneMonthPrice) { this.oneMonthPrice = oneMonthPrice; }

    public Double getThreeMonthPrice() { return threeMonthPrice; }
    public void setThreeMonthPrice(Double threeMonthPrice) { this.threeMonthPrice = threeMonthPrice; }

    public Double getSixMonthPrice() { return sixMonthPrice; }
    public void setSixMonthPrice(Double sixMonthPrice) { this.sixMonthPrice = sixMonthPrice; }

    public Double getOneWeekPrice() { return oneWeekPrice; }
    public void setOneWeekPrice(Double oneWeekPrice) { this.oneWeekPrice = oneWeekPrice; }

    public Double getCommunitySpotPrice() { return communitySpotPrice; }
    public void setCommunitySpotPrice(Double communitySpotPrice) { this.communitySpotPrice = communitySpotPrice; }

    public Double getSecureSpotPrice() { return secureSpotPrice; }
    public void setSecureSpotPrice(Double secureSpotPrice) { this.secureSpotPrice = secureSpotPrice; }

    public Integer getThroughput() { return throughput; }
    public void setThroughput(Integer throughput) { this.throughput = throughput; }

    // Convenience methods for boolean fields (since they're now nullable)
    public boolean isSecureCloudEnabled() {
        return secureCloud != null && secureCloud;
    }

    public boolean isCommunityCloudEnabled() {
        return communityCloud != null && communityCloud;
    }

    // Convenience methods for safe numeric access with defaults
    public int getMemoryInGbOrDefault(int defaultValue) {
        return memoryInGb != null ? memoryInGb : defaultValue;
    }

    public int getCudaCoresOrDefault(int defaultValue) {
        return cudaCores != null ? cudaCores : defaultValue;
    }

    public double getCommunityPriceOrDefault(double defaultValue) {
        return communityPrice != null ? communityPrice : defaultValue;
    }

    public double getSecurePriceOrDefault(double defaultValue) {
        return securePrice != null ? securePrice : defaultValue;
    }
}