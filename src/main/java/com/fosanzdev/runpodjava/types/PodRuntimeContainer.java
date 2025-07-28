package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "PodRuntimeContainer")
public class PodRuntimeContainer {
    @GraphQLField(fallbackPriority = 0)
    private Integer cpuPercent;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer memoryPercent;

    // Getters and Setters
    public Integer getCpuPercent() { return cpuPercent; }
    public void setCpuPercent(Integer cpuPercent) { this.cpuPercent = cpuPercent; }

    public Integer getMemoryPercent() { return memoryPercent; }
    public void setMemoryPercent(Integer memoryPercent) { this.memoryPercent = memoryPercent; }

    @Override
    public String toString() {
        return "PodRuntimeContainer{" +
                "cpuPercent=" + cpuPercent +
                ", memoryPercent=" + memoryPercent +
                '}';
    }
}