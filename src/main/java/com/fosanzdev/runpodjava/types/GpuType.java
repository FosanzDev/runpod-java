package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.util.List;

@GraphQLField(typeName = "GpuType")
public class GpuType {
    @GraphQLField(fallbackPriority = 10) // High priority for exclusion - often causes issues
    private LowestPrice lowestPrice;

    @GraphQLField(fallbackPriority = 0) // Essential field - never exclude
    private Integer maxGpuCount;

    @GraphQLField(fallbackPriority = 1) // Important field
    private Integer maxGpuCountCommunityCloud;

    @GraphQLField(fallbackPriority = 1)
    private Integer maxGpuCountSecureCloud;

    @GraphQLField(fallbackPriority = 1)
    private Integer minPodGpuCount;

    @GraphQLField(fallbackPriority = 5)
    private List<Integer> nodeGroupGpuSizes;

    @GraphQLField(fallbackPriority = 8) // Often problematic nested structure
    private List<DataCenter> nodeGroupDatacenters;

    @GraphQLField(fallbackPriority = 0) // Essential
    private String id;

    @GraphQLField(fallbackPriority = 0) // Essential
    private String displayName;

    @GraphQLField(fallbackPriority = 1)
    private String manufacturer;

    @GraphQLField(fallbackPriority = 1)
    private Integer memoryInGb;

    @GraphQLField(fallbackPriority = 1)
    private Integer cudaCores;

    @GraphQLField(fallbackPriority = 1)
    private Boolean secureCloud;

    @GraphQLField(fallbackPriority = 1)
    private Boolean communityCloud;

    @GraphQLField(fallbackPriority = 1)
    private Double securePrice;

    @GraphQLField(fallbackPriority = 5)
    private Double clusterPrice;

    @GraphQLField(fallbackPriority = 1)
    private Double communityPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double oneMonthPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double threeMonthPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double sixMonthPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double oneWeekPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double communitySpotPrice;

    @GraphQLField(fallbackPriority = 5)
    private Double secureSpotPrice;

    @GraphQLField(fallbackPriority = 7)
    private Integer throughput;

    // All getters and setters remain the same...
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

    // Convenience methods remain the same...
    public boolean isSecureCloudEnabled() {
        return secureCloud != null && secureCloud;
    }

    public boolean isCommunityCloudEnabled() {
        return communityCloud != null && communityCloud;
    }

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

    @Override
    public String toString() {
        return "GpuType{" +
                "lowestPrice=" + lowestPrice +
                ", maxGpuCount=" + maxGpuCount +
                ", maxGpuCountCommunityCloud=" + maxGpuCountCommunityCloud +
                ", maxGpuCountSecureCloud=" + maxGpuCountSecureCloud +
                ", minPodGpuCount=" + minPodGpuCount +
                ", nodeGroupGpuSizes=" + nodeGroupGpuSizes +
                ", nodeGroupDatacenters=" + nodeGroupDatacenters +
                ", id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryInGb=" + memoryInGb +
                ", cudaCores=" + cudaCores +
                ", secureCloud=" + secureCloud +
                ", communityCloud=" + communityCloud +
                ", securePrice=" + securePrice +
                ", clusterPrice=" + clusterPrice +
                ", communityPrice=" + communityPrice +
                ", oneMonthPrice=" + oneMonthPrice +
                ", threeMonthPrice=" + threeMonthPrice +
                ", sixMonthPrice=" + sixMonthPrice +
                ", oneWeekPrice=" + oneWeekPrice +
                ", communitySpotPrice=" + communitySpotPrice +
                ", secureSpotPrice=" + secureSpotPrice +
                ", throughput=" + throughput +
                '}';
    }
}