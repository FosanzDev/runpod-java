package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.time.LocalDateTime;

@GraphQLField(typeName = "SavingsPlan")
public class SavingsPlan {
    @GraphQLField(fallbackPriority = 0)
    private String id;
    
    @GraphQLField(fallbackPriority = 0)
    private LocalDateTime endTime;
    
    @GraphQLField(fallbackPriority = 0)
    private LocalDateTime startTime;
    
    @GraphQLField(fallbackPriority = 5)
    private GpuType gpuType;
    
    @GraphQLField(fallbackPriority = 1)
    private String podId;
    
    @GraphQLField(fallbackPriority = 1)
    private String gpuTypeId;
    
    @GraphQLField(fallbackPriority = 5)
    private Pod pod;
    
    @GraphQLField(fallbackPriority = 0)
    private String savingsPlanType;
    
    @GraphQLField(fallbackPriority = 0)
    private Double costPerHr;
    
    @GraphQLField(fallbackPriority = 1)
    private Double upfrontCost;
    
    @GraphQLField(fallbackPriority = 0)
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