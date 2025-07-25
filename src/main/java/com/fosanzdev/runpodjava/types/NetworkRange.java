package com.fosanzdev.runpodjava.types;

import java.util.List;

public class NetworkRange {
    private String id;
    private String cidr;
    private String podnetClusterId;
    private PodnetCluster podnetCluster;
    private List<IPAddress> addresses;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCidr() { return cidr; }
    public void setCidr(String cidr) { this.cidr = cidr; }

    public String getPodnetClusterId() { return podnetClusterId; }
    public void setPodnetClusterId(String podnetClusterId) { this.podnetClusterId = podnetClusterId; }

    public PodnetCluster getPodnetCluster() { return podnetCluster; }
    public void setPodnetCluster(PodnetCluster podnetCluster) { this.podnetCluster = podnetCluster; }

    public List<IPAddress> getAddresses() { return addresses; }
    public void setAddresses(List<IPAddress> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "NetworkRange{" +
                "id='" + id + '\'' +
                ", cidr='" + cidr + '\'' +
                ", podnetClusterId='" + podnetClusterId + '\'' +
                '}';
    }
}