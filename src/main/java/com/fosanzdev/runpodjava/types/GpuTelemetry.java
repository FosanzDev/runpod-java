package com.fosanzdev.runpodjava.types;

public class GpuTelemetry {
    private String id;
    private Double percentUtilization;
    private Double temperatureCelcius;
    private Double memoryUtilization;
    private Double powerWatts;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Double getPercentUtilization() { return percentUtilization; }
    public void setPercentUtilization(Double percentUtilization) { this.percentUtilization = percentUtilization; }

    public Double getTemperatureCelcius() { return temperatureCelcius; }
    public void setTemperatureCelcius(Double temperatureCelcius) { this.temperatureCelcius = temperatureCelcius; }

    public Double getMemoryUtilization() { return memoryUtilization; }
    public void setMemoryUtilization(Double memoryUtilization) { this.memoryUtilization = memoryUtilization; }

    public Double getPowerWatts() { return powerWatts; }
    public void setPowerWatts(Double powerWatts) { this.powerWatts = powerWatts; }

    @Override
    public String toString() {
        return "GpuTelemetry{" +
                "id='" + id + '\'' +
                ", percentUtilization=" + percentUtilization +
                ", temperatureCelcius=" + temperatureCelcius +
                ", memoryUtilization=" + memoryUtilization +
                ", powerWatts=" + powerWatts +
                '}';
    }
}