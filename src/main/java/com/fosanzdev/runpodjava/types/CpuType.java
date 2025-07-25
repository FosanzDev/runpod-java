package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "CpuType")
public class CpuType {
    @GraphQLField
    private String id;

    @GraphQLField
    private String displayName;

    @GraphQLField
    private String manufacturer;

    @GraphQLField
    private int cores;

    @GraphQLField
    private int threadsPerCore;

    @GraphQLField
    private String groupId;

    // Getters and Setters remain unchanged
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getCores() { return cores; }
    public void setCores(int cores) { this.cores = cores; }

    public int getThreadsPerCore() { return threadsPerCore; }
    public void setThreadsPerCore(int threadsPerCore) { this.threadsPerCore = threadsPerCore; }

    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.types.CpuType{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cores=" + cores +
                ", threadsPerCore=" + threadsPerCore +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}