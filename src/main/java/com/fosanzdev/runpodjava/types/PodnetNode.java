package com.fosanzdev.runpodjava.types;

public class PodnetNode {
    private String id;
    private String podnetClusterId;
    private PodnetCluster podnetCluster;
    private String publicIp;
    private String nebulaIp;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPodnetClusterId() { return podnetClusterId; }
    public void setPodnetClusterId(String podnetClusterId) { this.podnetClusterId = podnetClusterId; }

    public PodnetCluster getPodnetCluster() { return podnetCluster; }
    public void setPodnetCluster(PodnetCluster podnetCluster) { this.podnetCluster = podnetCluster; }

    public String getPublicIp() { return publicIp; }
    public void setPublicIp(String publicIp) { this.publicIp = publicIp; }

    public String getNebulaIp() { return nebulaIp; }
    public void setNebulaIp(String nebulaIp) { this.nebulaIp = nebulaIp; }

    @Override
    public String toString() {
        return "PodnetNode{" +
                "id='" + id + '\'' +
                ", podnetClusterId='" + podnetClusterId + '\'' +
                ", publicIp='" + publicIp + '\'' +
                ", nebulaIp='" + nebulaIp + '\'' +
                '}';
    }
}