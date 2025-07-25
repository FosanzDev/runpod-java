package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class Pod {
    private Double lowestBidPriceToResume;
    private String aiApiId;
    private String apiKey;
    private String clusterIp;
    private Integer clusterIdx;
    private String clusterCidr;
    private String consumerUserId;
    private Integer containerDiskInGb;
    private String containerRegistryAuthId;
    private Double costMultiplier;
    private Double costPerHr;
    private LocalDateTime createdAt;
    private Double adjustedCostPerHr;
    private String desiredStatus;
    private String dockerArgs;
    private String dockerId;
    private List<String> env;
    private Integer gpuCount;
    private Integer gpuPowerLimitPercent;
    private List<Gpu> gpus;
    private String id;
    private String imageName;
    private String lastStatusChange;
    private Boolean locked;
    private String machineId;
    private Double memoryInGb;
    private String name;
    private String podType;
    private Integer port;
    private String ports;
    private PodRegistry registry;
    private String templateId;
    private Integer uptimeSeconds;
    private Double vcpuCount;
    private Integer version;
    private Boolean volumeEncrypted;
    private Double volumeInGb;
    private String volumeKey;
    private String volumeMountPath;
    private LocalDateTime lastStartedAt;
    private String cpuFlavorId;
    private String machineType;
    private Integer slsVersion;
    private String networkVolumeId;
    private Boolean testPod;
    private String ideAiApiId;
    private CpuFlavor cpuFlavor;
    private PodRuntime runtime;
    private PodMachineInfo machine;
    private PodTelemetry latestTelemetry;
    private Endpoint endpoint;
    private NetworkVolume networkVolume;
    private List<SavingsPlan> savingsPlans;
    private String clusterId;
    private IPAddress ipAddress;

    // Getters and Setters
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

    public Integer getContainerDiskInGb() { return containerDiskInGb; }
    public void setContainerDiskInGb(Integer containerDiskInGb) { this.containerDiskInGb = containerDiskInGb; }

    public String getContainerRegistryAuthId() { return containerRegistryAuthId; }
    public void setContainerRegistryAuthId(String containerRegistryAuthId) { this.containerRegistryAuthId = containerRegistryAuthId; }

    public Double getCostMultiplier() { return costMultiplier; }
    public void setCostMultiplier(Double costMultiplier) { this.costMultiplier = costMultiplier; }

    public Double getCostPerHr() { return costPerHr; }
    public void setCostPerHr(Double costPerHr) { this.costPerHr = costPerHr; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Double getAdjustedCostPerHr() { return adjustedCostPerHr; }
    public void setAdjustedCostPerHr(Double adjustedCostPerHr) { this.adjustedCostPerHr = adjustedCostPerHr; }

    public String getDesiredStatus() { return desiredStatus; }
    public void setDesiredStatus(String desiredStatus) { this.desiredStatus = desiredStatus; }

    public String getDockerArgs() { return dockerArgs; }
    public void setDockerArgs(String dockerArgs) { this.dockerArgs = dockerArgs; }

    public String getDockerId() { return dockerId; }
    public void setDockerId(String dockerId) { this.dockerId = dockerId; }

    public List<String> getEnv() { return env; }
    public void setEnv(List<String> env) { this.env = env; }

    public Integer getGpuCount() { return gpuCount; }
    public void setGpuCount(Integer gpuCount) { this.gpuCount = gpuCount; }

    public Integer getGpuPowerLimitPercent() { return gpuPowerLimitPercent; }
    public void setGpuPowerLimitPercent(Integer gpuPowerLimitPercent) { this.gpuPowerLimitPercent = gpuPowerLimitPercent; }

    public List<Gpu> getGpus() { return gpus; }
    public void setGpus(List<Gpu> gpus) { this.gpus = gpus; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public String getLastStatusChange() { return lastStatusChange; }
    public void setLastStatusChange(String lastStatusChange) { this.lastStatusChange = lastStatusChange; }

    public Boolean getLocked() { return locked; }
    public void setLocked(Boolean locked) { this.locked = locked; }

    public String getMachineId() { return machineId; }
    public void setMachineId(String machineId) { this.machineId = machineId; }

    public Double getMemoryInGb() { return memoryInGb; }
    public void setMemoryInGb(Double memoryInGb) { this.memoryInGb = memoryInGb; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPodType() { return podType; }
    public void setPodType(String podType) { this.podType = podType; }

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

    public Double getVcpuCount() { return vcpuCount; }
    public void setVcpuCount(Double vcpuCount) { this.vcpuCount = vcpuCount; }

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

    @Override
    public String toString() {
        return "Pod{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", podType='" + podType + '\'' +
                ", desiredStatus='" + desiredStatus + '\'' +
                ", imageName='" + imageName + '\'' +
                ", gpuCount=" + gpuCount +
                ", memoryInGb=" + memoryInGb +
                ", vcpuCount=" + vcpuCount +
                ", costPerHr=" + costPerHr +
                '}';
    }
}