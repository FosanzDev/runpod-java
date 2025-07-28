package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "MachineSystem")
public class MachineSystem {
    @GraphQLField(fallbackPriority = 0)
    private String os;
    
    @GraphQLField(fallbackPriority = 0)
    private String cudaVersion;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer diskTotal;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer diskFree;
    
    @GraphQLField(fallbackPriority = 1)
    private String privateIp;
    
    @GraphQLField(fallbackPriority = 1)
    private String dockerVersion;
    
    @GraphQLField(fallbackPriority = 1)
    private String kernelVersion;
    
    @GraphQLField(fallbackPriority = 1)
    private String publicIp;

    // Getters and Setters
    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getCudaVersion() { return cudaVersion; }
    public void setCudaVersion(String cudaVersion) { this.cudaVersion = cudaVersion; }

    public Integer getDiskTotal() { return diskTotal; }
    public void setDiskTotal(Integer diskTotal) { this.diskTotal = diskTotal; }

    public Integer getDiskFree() { return diskFree; }
    public void setDiskFree(Integer diskFree) { this.diskFree = diskFree; }

    public String getPrivateIp() { return privateIp; }
    public void setPrivateIp(String privateIp) { this.privateIp = privateIp; }

    public String getDockerVersion() { return dockerVersion; }
    public void setDockerVersion(String dockerVersion) { this.dockerVersion = dockerVersion; }

    public String getKernelVersion() { return kernelVersion; }
    public void setKernelVersion(String kernelVersion) { this.kernelVersion = kernelVersion; }

    public String getPublicIp() { return publicIp; }
    public void setPublicIp(String publicIp) { this.publicIp = publicIp; }

    @Override
    public String toString() {
        return "MachineSystem{" +
                "os='" + os + '\'' +
                ", cudaVersion='" + cudaVersion + '\'' +
                ", diskTotal=" + diskTotal +
                ", diskFree=" + diskFree +
                ", privateIp='" + privateIp + '\'' +
                ", dockerVersion='" + dockerVersion + '\'' +
                ", kernelVersion='" + kernelVersion + '\'' +
                ", publicIp='" + publicIp + '\'' +
                '}';
    }
}