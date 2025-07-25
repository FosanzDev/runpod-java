package com.fosanzdev.runpodjava.types;

import java.util.List;

public class PodnetCluster {
    private String id;
    private String name;
    private String description;
    private List<PodnetNode> podnetNodes;
    private List<NetworkRange> networkRanges;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<PodnetNode> getPodnetNodes() { return podnetNodes; }
    public void setPodnetNodes(List<PodnetNode> podnetNodes) { this.podnetNodes = podnetNodes; }

    public List<NetworkRange> getNetworkRanges() { return networkRanges; }
    public void setNetworkRanges(List<NetworkRange> networkRanges) { this.networkRanges = networkRanges; }

    @Override
    public String toString() {
        return "PodnetCluster{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}