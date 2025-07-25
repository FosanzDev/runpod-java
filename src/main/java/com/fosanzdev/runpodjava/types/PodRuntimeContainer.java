package com.fosanzdev.runpodjava.types;

public class PodRuntimeContainer {
    private Integer cpuPercent;
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