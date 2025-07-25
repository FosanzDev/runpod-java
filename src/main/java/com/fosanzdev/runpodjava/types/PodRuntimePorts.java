package com.fosanzdev.runpodjava.types;

public class PodRuntimePorts {
    private String ip;
    private Boolean isIpPublic;
    private Integer privatePort;
    private Integer publicPort;
    private String type;

    // Getters and Setters
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public Boolean getIsIpPublic() { return isIpPublic; }
    public void setIsIpPublic(Boolean isIpPublic) { this.isIpPublic = isIpPublic; }

    public Integer getPrivatePort() { return privatePort; }
    public void setPrivatePort(Integer privatePort) { this.privatePort = privatePort; }

    public Integer getPublicPort() { return publicPort; }
    public void setPublicPort(Integer publicPort) { this.publicPort = publicPort; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "PodRuntimePorts{" +
                "ip='" + ip + '\'' +
                ", isIpPublic=" + isIpPublic +
                ", privatePort=" + privatePort +
                ", publicPort=" + publicPort +
                ", type='" + type + '\'' +
                '}';
    }
}