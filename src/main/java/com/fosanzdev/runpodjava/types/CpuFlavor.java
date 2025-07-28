package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "CpuFlavor")
public class CpuFlavor {

    @GraphQLField(fallbackPriority = 0)
    private String id;

    @GraphQLField
    private String groupId;

    @GraphQLField
    private String groupName;

    @GraphQLField
    private String displayName;

    @GraphQLField
    private Double minVcpu;

    @GraphQLField
    private Integer maxVcpu;

    @GraphQLField
    private Boolean vcpuBurstable;

    @GraphQLField
    private Double ramMultiplier;

    @GraphQLField
    private Integer diskLimitPerVcpu;

    @GraphQLField
    private Specifics specifics;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public Double getMinVcpu() { return minVcpu; }
    public void setMinVcpu(Double minVcpu) { this.minVcpu = minVcpu; }

    public Integer getMaxVcpu() { return maxVcpu; }
    public void setMaxVcpu(Integer maxVcpu) { this.maxVcpu = maxVcpu; }

    public Boolean getVcpuBurstable() { return vcpuBurstable; }
    public void setVcpuBurstable(Boolean vcpuBurstable) { this.vcpuBurstable = vcpuBurstable; }

    public Double getRamMultiplier() { return ramMultiplier; }
    public void setRamMultiplier(Double ramMultiplier) { this.ramMultiplier = ramMultiplier; }

    public Integer getDiskLimitPerVcpu() { return diskLimitPerVcpu; }
    public void setDiskLimitPerVcpu(Integer diskLimitPerVcpu) { this.diskLimitPerVcpu = diskLimitPerVcpu; }

    public Specifics getSpecifics() { return specifics; }
    public void setSpecifics(Specifics specifics) { this.specifics = specifics; }

    @Override
    public String toString() {
        return "CpuFlavor{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", minVcpu=" + minVcpu +
                ", maxVcpu=" + maxVcpu +
                ", vcpuBurstable=" + vcpuBurstable +
                ", ramMultiplier=" + ramMultiplier +
                ", diskLimitPerVcpu=" + diskLimitPerVcpu +
                '}';
    }
}