package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.time.LocalDateTime;
import java.util.List;

@GraphQLField(typeName = "Pod")
public class Pod {
    // Essential fields - never exclude (priority 0)
    @GraphQLField(fallbackPriority = 0)
    private String id;

    @GraphQLField(fallbackPriority = 0)
    private String name;

    @GraphQLField(fallbackPriority = 0)
    private String desiredStatus;

    @GraphQLField(fallbackPriority = 0)
    private String imageName;

    // Important fields - exclude last (priority 1)
    @GraphQLField(fallbackPriority = 1)
    private Integer containerDiskInGb;

    @GraphQLField(fallbackPriority = 1)
    private Double memoryInGb;

    @GraphQLField(fallbackPriority = 1)
    private Double vcpuCount;

    @GraphQLField(fallbackPriority = 1)
    private Integer gpuCount;

    @GraphQLField(fallbackPriority = 1)
    private Double costPerHr;

    @GraphQLField(fallbackPriority = 1)
    private LocalDateTime createdAt;

    @GraphQLField(fallbackPriority = 1)
    private String podType;

    @GraphQLField(fallbackPriority = 1)
    private String machineId;

    // Normal fields (priority 5)
    @GraphQLField(fallbackPriority = 5)
    private Double lowestBidPriceToResume;

    @GraphQLField(fallbackPriority = 5)
    private String aiApiId;

    @GraphQLField(fallbackPriority = 5)
    private String apiKey;

    @GraphQLField(fallbackPriority = 5)
    private String clusterIp;

    @GraphQLField(fallbackPriority = 5)
    private Integer clusterIdx;

    @GraphQLField(fallbackPriority = 5)
    private String clusterCidr;

    @GraphQLField(fallbackPriority = 5)
    private String consumerUserId;

    @GraphQLField(fallbackPriority = 5)
    private String containerRegistryAuthId;

    @GraphQLField(fallbackPriority = 5)
    private Double costMultiplier;

    @GraphQLField(fallbackPriority = 5)
    private Double adjustedCostPerHr;

    @GraphQLField(fallbackPriority = 5)
    private String dockerArgs;

    @GraphQLField(fallbackPriority = 5)
    private String dockerId;

    @GraphQLField(fallbackPriority = 5)
    private List<String> env;

    @GraphQLField(fallbackPriority = 5)
    private Integer gpuPowerLimitPercent;

    @GraphQLField(fallbackPriority = 5)
    private String lastStatusChange;

    @GraphQLField(fallbackPriority = 5)
    private Boolean locked;

    @GraphQLField(fallbackPriority = 5)
    private Integer port;

    @GraphQLField(fallbackPriority = 5)
    private String ports;

    @GraphQLField(fallbackPriority = 5)
    private String templateId;

    @GraphQLField(fallbackPriority = 5)
    private Integer uptimeSeconds;

    @GraphQLField(fallbackPriority = 5)
    private Integer version;

    @GraphQLField(fallbackPriority = 5)
    private Boolean volumeEncrypted;

    @GraphQLField(fallbackPriority = 5)
    private Double volumeInGb;

    @GraphQLField(fallbackPriority = 5)
    private String volumeKey;

    @GraphQLField(fallbackPriority = 5)
    private String volumeMountPath;

    @GraphQLField(fallbackPriority = 5)
    private LocalDateTime lastStartedAt;

    @GraphQLField(fallbackPriority = 5)
    private String cpuFlavorId;

    @GraphQLField(fallbackPriority = 5)
    private String machineType;

    @GraphQLField(fallbackPriority = 5)
    private Integer slsVersion;

    @GraphQLField(fallbackPriority = 5)
    private String networkVolumeId;

    @GraphQLField(fallbackPriority = 5)
    private Boolean testPod;

    @GraphQLField(fallbackPriority = 5)
    private String ideAiApiId;

    @GraphQLField(fallbackPriority = 5)
    private String clusterId;

    // Complex nested objects - often problematic (priority 8)
    @GraphQLField(fallbackPriority = 8)
    private List<Gpu> gpus;

    @GraphQLField(fallbackPriority = 8)
    private PodRegistry registry;

    @GraphQLField(fallbackPriority = 8)
    private CpuFlavor cpuFlavor;

    @GraphQLField(fallbackPriority = 8)
    private PodRuntime runtime;

    @GraphQLField(fallbackPriority = 8)
    private PodMachineInfo machine;

    @GraphQLField(fallbackPriority = 8)
    private PodTelemetry latestTelemetry;

    @GraphQLField(fallbackPriority = 8)
    private Endpoint endpoint;

    @GraphQLField(fallbackPriority = 8)
    private NetworkVolume networkVolume;

    @GraphQLField(fallbackPriority = 8)
    private List<SavingsPlan> savingsPlans;

    @GraphQLField(fallbackPriority = 8)
    private IPAddress ipAddress;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesiredStatus() { return desiredStatus; }
    public void setDesiredStatus(String desiredStatus) { this.desiredStatus = desiredStatus; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public Integer getContainerDiskInGb() { return containerDiskInGb; }
    public void setContainerDiskInGb(Integer containerDiskInGb) { this.containerDiskInGb = containerDiskInGb; }

    public Double getMemoryInGb() { return memoryInGb; }
    public void setMemoryInGb(Double memoryInGb) { this.memoryInGb = memoryInGb; }

    public Double getVcpuCount() { return vcpuCount; }
    public void setVcpuCount(Double vcpuCount) { this.vcpuCount = vcpuCount; }

    public Integer getGpuCount() { return gpuCount; }
    public void setGpuCount(Integer gpuCount) { this.gpuCount = gpuCount; }

    public Double getCostPerHr() { return costPerHr; }
    public void setCostPerHr(Double costPerHr) { this.costPerHr = costPerHr; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getPodType() { return podType; }
    public void setPodType(String podType) { this.podType = podType; }

    public String getMachineId() { return machineId; }
    public void setMachineId(String machineId) { this.machineId = machineId; }

    public Double getLowestBidPriceToResume() { return lowestBidPriceToResume; }
    public void setLowestBidPriceToResume(Double lowestBidPriceToResume) { this.lowestBidPriceToResume = lowestBidPriceToResume; }

    public String getAiApiId() { return aiApiId; }
    public void setAiApiId(String aiApiId) { this.aiApiId = aiApiId; }

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public String getClusterIp() { return clusterIp; }
    public void setClusterIp(String clusterIp) { this.clusterIp = clusterIp; }

    public Integer getClusterIdx() { return clusterIdx; }
    public void setClusterIdx(Integer clusterIdx) { this.clusterIdx = clusterIdx; }

    public String getClusterCidr() { return clusterCidr; }
    public void setClusterCidr(String clusterCidr) { this.clusterCidr = clusterCidr; }

    public String getConsumerUserId() { return consumerUserId; }
    public void setConsumerUserId(String consumerUserId) { this.consumerUserId = consumerUserId; }

    public String getContainerRegistryAuthId() { return containerRegistryAuthId; }
    public void setContainerRegistryAuthId(String containerRegistryAuthId) { this.containerRegistryAuthId = containerRegistryAuthId; }

    public Double getCostMultiplier() { return costMultiplier; }
    public void setCostMultiplier(Double costMultiplier) { this.costMultiplier = costMultiplier; }

    public Double getAdjustedCostPerHr() { return adjustedCostPerHr; }
    public void setAdjustedCostPerHr(Double adjustedCostPerHr) { this.adjustedCostPerHr = adjustedCostPerHr; }

    public String getDockerArgs() { return dockerArgs; }
    public void setDockerArgs(String dockerArgs) { this.dockerArgs = dockerArgs; }

    public String getDockerId() { return dockerId; }
    public void setDockerId(String dockerId) { this.dockerId = dockerId; }

    public List<String> getEnv() { return env; }
    public void setEnv(List<String> env) { this.env = env; }

    public Integer getGpuPowerLimitPercent() { return gpuPowerLimitPercent; }
    public void setGpuPowerLimitPercent(Integer gpuPowerLimitPercent) { this.gpuPowerLimitPercent = gpuPowerLimitPercent; }

    public List<Gpu> getGpus() { return gpus; }
    public void setGpus(List<Gpu> gpus) { this.gpus = gpus; }

    public String getLastStatusChange() { return lastStatusChange; }
    public void setLastStatusChange(String lastStatusChange) { this.lastStatusChange = lastStatusChange; }

    public Boolean getLocked() { return locked; }
    public void setLocked(Boolean locked) { this.locked = locked; }

    public Integer getPort() { return port; }
    public void setPort(Integer port) { this.port = port; }

    public String getPorts() { return ports; }
    public void setPorts(String ports) { this.ports = ports; }

    public PodRegistry getRegistry() { return registry; }
    public void setRegistry(PodRegistry registry) { this.registry = registry; }

    public String getTemplateId() { return templateId; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }

    public Integer getUptimeSeconds() { return uptimeSeconds; }
    public void setUptimeSeconds(Integer uptimeSeconds) { this.uptimeSeconds = uptimeSeconds; }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }

    public Boolean getVolumeEncrypted() { return volumeEncrypted; }
    public void setVolumeEncrypted(Boolean volumeEncrypted) { this.volumeEncrypted = volumeEncrypted; }

    public Double getVolumeInGb() { return volumeInGb; }
    public void setVolumeInGb(Double volumeInGb) { this.volumeInGb = volumeInGb; }

    public String getVolumeKey() { return volumeKey; }
    public void setVolumeKey(String volumeKey) { this.volumeKey = volumeKey; }

    public String getVolumeMountPath() { return volumeMountPath; }
    public void setVolumeMountPath(String volumeMountPath) { this.volumeMountPath = volumeMountPath; }

    public LocalDateTime getLastStartedAt() { return lastStartedAt; }
    public void setLastStartedAt(LocalDateTime lastStartedAt) { this.lastStartedAt = lastStartedAt; }

    public String getCpuFlavorId() { return cpuFlavorId; }
    public void setCpuFlavorId(String cpuFlavorId) { this.cpuFlavorId = cpuFlavorId; }

    public String getMachineType() { return machineType; }
    public void setMachineType(String machineType) { this.machineType = machineType; }

    public Integer getSlsVersion() { return slsVersion; }
    public void setSlsVersion(Integer slsVersion) { this.slsVersion = slsVersion; }

    public String getNetworkVolumeId() { return networkVolumeId; }
    public void setNetworkVolumeId(String networkVolumeId) { this.networkVolumeId = networkVolumeId; }

    public Boolean getTestPod() { return testPod; }
    public void setTestPod(Boolean testPod) { this.testPod = testPod; }

    public String getIdeAiApiId() { return ideAiApiId; }
    public void setIdeAiApiId(String ideAiApiId) { this.ideAiApiId = ideAiApiId; }

    public CpuFlavor getCpuFlavor() { return cpuFlavor; }
    public void setCpuFlavor(CpuFlavor cpuFlavor) { this.cpuFlavor = cpuFlavor; }

    public PodRuntime getRuntime() { return runtime; }
    public void setRuntime(PodRuntime runtime) { this.runtime = runtime; }

    public PodMachineInfo getMachine() { return machine; }
    public void setMachine(PodMachineInfo machine) { this.machine = machine; }

    public PodTelemetry getLatestTelemetry() { return latestTelemetry; }
    public void setLatestTelemetry(PodTelemetry latestTelemetry) { this.latestTelemetry = latestTelemetry; }

    public Endpoint getEndpoint() { return endpoint; }
    public void setEndpoint(Endpoint endpoint) { this.endpoint = endpoint; }

    public NetworkVolume getNetworkVolume() { return networkVolume; }
    public void setNetworkVolume(NetworkVolume networkVolume) { this.networkVolume = networkVolume; }

    public List<SavingsPlan> getSavingsPlans() { return savingsPlans; }
    public void setSavingsPlans(List<SavingsPlan> savingsPlans) { this.savingsPlans = savingsPlans; }

    public String getClusterId() { return clusterId; }
    public void setClusterId(String clusterId) { this.clusterId = clusterId; }

    public IPAddress getIpAddress() { return ipAddress; }
    public void setIpAddress(IPAddress ipAddress) { this.ipAddress = ipAddress; }

    // Convenience methods
    public boolean isLocked() {
        return locked != null && locked;
    }

    public boolean isVolumeEncrypted() {
        return volumeEncrypted != null && volumeEncrypted;
    }

    public boolean isTestPod() {
        return testPod != null && testPod;
    }

    public double getCostPerHrOrDefault(double defaultValue) {
        return costPerHr != null ? costPerHr : defaultValue;
    }

    public double getMemoryInGbOrDefault(double defaultValue) {
        return memoryInGb != null ? memoryInGb : defaultValue;
    }

    public int getGpuCountOrDefault(int defaultValue) {
        return gpuCount != null ? gpuCount : defaultValue;
    }

    @Override
    public String toString() {
        return "Pod{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desiredStatus='" + desiredStatus + '\'' +
                ", imageName='" + imageName + '\'' +
                ", containerDiskInGb=" + containerDiskInGb +
                ", memoryInGb=" + memoryInGb +
                ", vcpuCount=" + vcpuCount +
                ", gpuCount=" + gpuCount +
                ", costPerHr=" + costPerHr +
                ", createdAt=" + createdAt +
                ", podType='" + podType + '\'' +
                ", machineId='" + machineId + '\'' +
                ", locked=" + locked +
                '}';
    }
}