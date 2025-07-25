package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "CpuType")
public class CpuType {
    @GraphQLField(fallbackPriority = 0) // Essential field - never exclude
    private String id;

    @GraphQLField(fallbackPriority = 0) // Essential field - never exclude
    private String displayName;

    @GraphQLField(fallbackPriority = 1) // Important field
    private String manufacturer;

    @GraphQLField(fallbackPriority = 1) // Important field
    private Integer cores;

    @GraphQLField(fallbackPriority = 1) // Important field
    private Integer threadsPerCore;

    @GraphQLField(fallbackPriority = 1) // Important field
    private String groupId;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Integer getCores() { return cores; }
    public void setCores(Integer cores) { this.cores = cores; }

    public Integer getThreadsPerCore() { return threadsPerCore; }
    public void setThreadsPerCore(Integer threadsPerCore) { this.threadsPerCore = threadsPerCore; }

    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }

    // Convenience methods
    public int getCoresOrDefault(int defaultValue) {
        return cores != null ? cores : defaultValue;
    }

    public int getThreadsPerCoreOrDefault(int defaultValue) {
        return threadsPerCore != null ? threadsPerCore : defaultValue;
    }

    public int getTotalThreads() {
        return getCoresOrDefault(0) * getThreadsPerCoreOrDefault(1);
    }

    @Override
    public String toString() {
        return "CpuType{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cores=" + cores +
                ", threadsPerCore=" + threadsPerCore +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}