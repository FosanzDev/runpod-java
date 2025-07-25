package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "GpuAvailability")
public class GpuAvailability {
    @GraphQLField
    private boolean available;

    @GraphQLField
    private String stockStatus;

    @GraphQLField
    private String gpuTypeId;

    @GraphQLField
    private String gpuTypeDisplayName;

    @GraphQLField
    private String displayName;

    @GraphQLField
    private String id;

    // Getters and Setters remain unchanged
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getStockStatus() { return stockStatus; }
    public void setStockStatus(String stockStatus) { this.stockStatus = stockStatus; }

    public String getGpuTypeId() { return gpuTypeId; }
    public void setGpuTypeId(String gpuTypeId) { this.gpuTypeId = gpuTypeId; }

    public String getGpuTypeDisplayName() { return gpuTypeDisplayName; }
    public void setGpuTypeDisplayName(String gpuTypeDisplayName) { this.gpuTypeDisplayName = gpuTypeDisplayName; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "GpuAvailability{" +
                "available=" + available +
                ", stockStatus='" + stockStatus + '\'' +
                ", gpuTypeId='" + gpuTypeId + '\'' +
                ", gpuTypeDisplayName='" + gpuTypeDisplayName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}