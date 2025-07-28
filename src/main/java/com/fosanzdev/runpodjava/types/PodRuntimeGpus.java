package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "PodRuntimeGpus")
public class PodRuntimeGpus {
    @GraphQLField(fallbackPriority = 0)
    private String id;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer gpuUtilPercent;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer memoryUtilPercent;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getGpuUtilPercent() { return gpuUtilPercent; }
    public void setGpuUtilPercent(Integer gpuUtilPercent) { this.gpuUtilPercent = gpuUtilPercent; }

    public Integer getMemoryUtilPercent() { return memoryUtilPercent; }
    public void setMemoryUtilPercent(Integer memoryUtilPercent) { this.memoryUtilPercent = memoryUtilPercent; }

    @Override
    public String toString() {
        return "PodRuntimeGpus{" +
                "id='" + id + '\'' +
                ", gpuUtilPercent=" + gpuUtilPercent +
                ", memoryUtilPercent=" + memoryUtilPercent +
                '}';
    }
}