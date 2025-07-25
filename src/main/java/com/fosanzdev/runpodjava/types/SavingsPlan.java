package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;

public class SavingsPlan {
    private String id;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private GpuType gpuType;
    private String podId;
    private String gpuTypeId;
    private Pod pod;
    private String savingsPlanType;
    private Double costPerHr;
    private Double upfrontCost;
    private String planLength;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public GpuType getGpuType() { return gpuType; }
    public void setGpuType(GpuType gpuType) { this.gpuType = gpuType; }

    public String getPodId() { return podId; }
    public void setPodId(String podId) { this.podId = podId; }

    public String getGpuTypeId() { return gpuTypeId; }
    public void setGpuTypeId(String gpuTypeId) { this.gpuTypeId = gpuTypeId; }

    public Pod getPod() { return pod; }
    public void setPod(Pod pod) { this.pod = pod; }

    public String getSavingsPlanType() { return savingsPlanType; }
    public void setSavingsPlanType(String savingsPlanType) { this.savingsPlanType = savingsPlanType; }

    public Double getCostPerHr() { return costPerHr; }
    public void setCostPerHr(Double costPerHr) { this.costPerHr = costPerHr; }

    public Double getUpfrontCost() { return upfrontCost; }
    public void setUpfrontCost(Double upfrontCost) { this.upfrontCost = upfrontCost; }

    public String getPlanLength() { return planLength; }
    public void setPlanLength(String planLength) { this.planLength = planLength; }

    @Override
    public String toString() {
        return "SavingsPlan{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", savingsPlanType='" + savingsPlanType + '\'' +
                ", costPerHr=" + costPerHr +
                ", upfrontCost=" + upfrontCost +
                ", planLength='" + planLength + '\'' +
                '}';
    }
}