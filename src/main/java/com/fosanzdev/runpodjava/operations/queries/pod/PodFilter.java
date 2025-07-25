package com.fosanzdev.runpodjava.operations.queries.pod;

public class PodFilter {
    private String podId;

    // Constructors
    public PodFilter() {}

    public PodFilter(String podId) {
        this.podId = podId;
    }

    // Getters and Setters
    public String getPodId() { return podId; }
    public void setPodId(String podId) { this.podId = podId; }

    @Override
    public String toString() {
        return "PodFilter{" +
                "podId='" + podId + '\'' +
                '}';
    }
}