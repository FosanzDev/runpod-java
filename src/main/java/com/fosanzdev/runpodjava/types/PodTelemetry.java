package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class PodTelemetry {
    private String state;
    private LocalDateTime time;
    private Double cpuUtilization;
    private Double memoryUtilization;
    private GpuTelemetry averageGpuMetrics;
    private List<GpuTelemetry> individualGpuMetrics;
    private Integer lastStateTransitionTimestamp;

    // Getters and Setters
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public Double getCpuUtilization() { return cpuUtilization; }
    public void setCpuUtilization(Double cpuUtilization) { this.cpuUtilization = cpuUtilization; }

    public Double getMemoryUtilization() { return memoryUtilization; }
    public void setMemoryUtilization(Double memoryUtilization) { this.memoryUtilization = memoryUtilization; }

    public GpuTelemetry getAverageGpuMetrics() { return averageGpuMetrics; }
    public void setAverageGpuMetrics(GpuTelemetry averageGpuMetrics) { this.averageGpuMetrics = averageGpuMetrics; }

    public List<GpuTelemetry> getIndividualGpuMetrics() { return individualGpuMetrics; }
    public void setIndividualGpuMetrics(List<GpuTelemetry> individualGpuMetrics) { this.individualGpuMetrics = individualGpuMetrics; }

    public Integer getLastStateTransitionTimestamp() { return lastStateTransitionTimestamp; }
    public void setLastStateTransitionTimestamp(Integer lastStateTransitionTimestamp) { this.lastStateTransitionTimestamp = lastStateTransitionTimestamp; }

    @Override
    public String toString() {
        return "PodTelemetry{" +
                "state='" + state + '\'' +
                ", time=" + time +
                ", cpuUtilization=" + cpuUtilization +
                ", memoryUtilization=" + memoryUtilization +
                ", averageGpuMetrics=" + averageGpuMetrics +
                ", lastStateTransitionTimestamp=" + lastStateTransitionTimestamp +
                '}';
    }
}