package com.fosanzdev.runpodjava.types;

public class GpuAvailability {
    private boolean available;
    private String stockStatus;
    private String gpuTypeId;
    private GpuType gpuType;
    private String gpuTypeDisplayName;
    private String displayName;
    private String id;

    // Getters and Setters
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getStockStatus() { return stockStatus; }
    public void setStockStatus(String stockStatus) { this.stockStatus = stockStatus; }

    public String getGpuTypeId() { return gpuTypeId; }
    public void setGpuTypeId(String gpuTypeId) { this.gpuTypeId = gpuTypeId; }

    public GpuType getGpuType() { return gpuType; }
    public void setGpuType(GpuType gpuType) { this.gpuType = gpuType; }

    public String getGpuTypeDisplayName() { return gpuTypeDisplayName; }
    public void setGpuTypeDisplayName(String gpuTypeDisplayName) { this.gpuTypeDisplayName = gpuTypeDisplayName; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.types.GpuAvailability{" +
                "available=" + available +
                ", stockStatus='" + stockStatus + '\'' +
                ", gpuTypeId='" + gpuTypeId + '\'' +
                ", gpuType=" + gpuType +
                ", gpuTypeDisplayName='" + gpuTypeDisplayName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}