package com.fosanzdev.runpodjava.operations.queries.gpu;

import java.util.List;

public class GpuTypeFilter {
    private String id;
    private List<String> ids;
    private Boolean cluster;

    // Constructors
    public GpuTypeFilter() {}

    public GpuTypeFilter(String id) {
        this.id = id;
    }

    public GpuTypeFilter(List<String> ids) {
        this.ids = ids;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Boolean getCluster() {
        return cluster;
    }

    public void setCluster(Boolean cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.operations.queries.gpu.GpuTypeFilter{" +
                "id='" + id + '\'' +
                ", ids=" + ids +
                ", cluster=" + cluster +
                '}';
    }
}