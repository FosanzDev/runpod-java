package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.time.LocalDateTime;

@GraphQLField(typeName = "PodMachineInfo")
public class PodMachineInfo {
    @GraphQLField(fallbackPriority = 0)
    private String id;
    
    @GraphQLField(fallbackPriority = 0)
    private Double costPerHr;
    
    @GraphQLField(fallbackPriority = 1)
    private Double currentPricePerGpu;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer diskMBps;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer gpuAvailable;
    
    @GraphQLField(fallbackPriority = 0)
    private String gpuDisplayName;
    
    @GraphQLField(fallbackPriority = 1)
    private String gpuTypeId;
    
    @GraphQLField(fallbackPriority = 1)
    private GpuType gpuType;
    
    @GraphQLField(fallbackPriority = 1)
    private Boolean listed;
    
    @GraphQLField(fallbackPriority = 0)
    private String location;
    
    @GraphQLField(fallbackPriority = 0)
    private String machineType;
    
    @GraphQLField(fallbackPriority = 5)
    private LocalDateTime maintenanceEnd;
    
    @GraphQLField(fallbackPriority = 5)
    private String maintenanceNote;
    
    @GraphQLField(fallbackPriority = 5)
    private LocalDateTime maintenanceStart;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer maxDownloadSpeedMbps;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer maxUploadSpeedMbps;
    
    @GraphQLField(fallbackPriority = 5)
    private String note;
    
    @GraphQLField(fallbackPriority = 1)
    private String podHostId;
    
    @GraphQLField(fallbackPriority = 1)
    private String runpodIp;
    
    @GraphQLField(fallbackPriority = 1)
    private Boolean secureCloud;
    
    @GraphQLField(fallbackPriority = 1)
    private Boolean supportPublicIp;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer minPodGpuCount;
    
    @GraphQLField(fallbackPriority = 5)
    private MachineSystem machineSystem;
    
    @GraphQLField(fallbackPriority = 1)
    private String dataCenterId;
    
    @GraphQLField(fallbackPriority = 1)
    private String cpuTypeId;
    
    @GraphQLField(fallbackPriority = 5)
    private CpuType cpuType;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer cpuCount;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer vcpuTotal;
    
    @GraphQLField(fallbackPriority = 1)
    private Double vcpuReserved;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer memoryTotal;
    
    @GraphQLField(fallbackPriority = 1)
    private Double memoryReserved;
    
    @GraphQLField(fallbackPriority = 1)
    private Boolean globalNetwork;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Double getCostPerHr() { return costPerHr; }
    public void setCostPerHr(Double costPerHr) { this.costPerHr = costPerHr; }

    public Double getCurrentPricePerGpu() { return currentPricePerGpu; }
    public void setCurrentPricePerGpu(Double currentPricePerGpu) { this.currentPricePerGpu = currentPricePerGpu; }

    public Integer getDiskMBps() { return diskMBps; }
    public void setDiskMBps(Integer diskMBps) { this.diskMBps = diskMBps; }

    public Integer getGpuAvailable() { return gpuAvailable; }
    public void setGpuAvailable(Integer gpuAvailable) { this.gpuAvailable = gpuAvailable; }

    public String getGpuDisplayName() { return gpuDisplayName; }
    public void setGpuDisplayName(String gpuDisplayName) { this.gpuDisplayName = gpuDisplayName; }

    public String getGpuTypeId() { return gpuTypeId; }
    public void setGpuTypeId(String gpuTypeId) { this.gpuTypeId = gpuTypeId; }

    public GpuType getGpuType() { return gpuType; }
    public void setGpuType(GpuType gpuType) { this.gpuType = gpuType; }

    public Boolean getListed() { return listed; }
    public void setListed(Boolean listed) { this.listed = listed; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getMachineType() { return machineType; }
    public void setMachineType(String machineType) { this.machineType = machineType; }

    public LocalDateTime getMaintenanceEnd() { return maintenanceEnd; }
    public void setMaintenanceEnd(LocalDateTime maintenanceEnd) { this.maintenanceEnd = maintenanceEnd; }

    public String getMaintenanceNote() { return maintenanceNote; }
    public void setMaintenanceNote(String maintenanceNote) { this.maintenanceNote = maintenanceNote; }

    public LocalDateTime getMaintenanceStart() { return maintenanceStart; }
    public void setMaintenanceStart(LocalDateTime maintenanceStart) { this.maintenanceStart = maintenanceStart; }

    public Integer getMaxDownloadSpeedMbps() { return maxDownloadSpeedMbps; }
    public void setMaxDownloadSpeedMbps(Integer maxDownloadSpeedMbps) { this.maxDownloadSpeedMbps = maxDownloadSpeedMbps; }

    public Integer getMaxUploadSpeedMbps() { return maxUploadSpeedMbps; }
    public void setMaxUploadSpeedMbps(Integer maxUploadSpeedMbps) { this.maxUploadSpeedMbps = maxUploadSpeedMbps; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getPodHostId() { return podHostId; }
    public void setPodHostId(String podHostId) { this.podHostId = podHostId; }

    public String getRunpodIp() { return runpodIp; }
    public void setRunpodIp(String runpodIp) { this.runpodIp = runpodIp; }

    public Boolean getSecureCloud() { return secureCloud; }
    public void setSecureCloud(Boolean secureCloud) { this.secureCloud = secureCloud; }

    public Boolean getSupportPublicIp() { return supportPublicIp; }
    public void setSupportPublicIp(Boolean supportPublicIp) { this.supportPublicIp = supportPublicIp; }

    public Integer getMinPodGpuCount() { return minPodGpuCount; }
    public void setMinPodGpuCount(Integer minPodGpuCount) { this.minPodGpuCount = minPodGpuCount; }

    public MachineSystem getMachineSystem() { return machineSystem; }
    public void setMachineSystem(MachineSystem machineSystem) { this.machineSystem = machineSystem; }

    public String getDataCenterId() { return dataCenterId; }
    public void setDataCenterId(String dataCenterId) { this.dataCenterId = dataCenterId; }

    public String getCpuTypeId() { return cpuTypeId; }
    public void setCpuTypeId(String cpuTypeId) { this.cpuTypeId = cpuTypeId; }

    public CpuType getCpuType() { return cpuType; }
    public void setCpuType(CpuType cpuType) { this.cpuType = cpuType; }

    public Integer getCpuCount() { return cpuCount; }
    public void setCpuCount(Integer cpuCount) { this.cpuCount = cpuCount; }

    public Integer getVcpuTotal() { return vcpuTotal; }
    public void setVcpuTotal(Integer vcpuTotal) { this.vcpuTotal = vcpuTotal; }

    public Double getVcpuReserved() { return vcpuReserved; }
    public void setVcpuReserved(Double vcpuReserved) { this.vcpuReserved = vcpuReserved; }

    public Integer getMemoryTotal() { return memoryTotal; }
    public void setMemoryTotal(Integer memoryTotal) { this.memoryTotal = memoryTotal; }

    public Double getMemoryReserved() { return memoryReserved; }
    public void setMemoryReserved(Double memoryReserved) { this.memoryReserved = memoryReserved; }

    public Boolean getGlobalNetwork() { return globalNetwork; }
    public void setGlobalNetwork(Boolean globalNetwork) { this.globalNetwork = globalNetwork; }

    @Override
    public String toString() {
        return "PodMachineInfo{" +
                "id='" + id + '\'' +
                ", machineType='" + machineType + '\'' +
                ", location='" + location + '\'' +
                ", gpuDisplayName='" + gpuDisplayName + '\'' +
                ", gpuAvailable=" + gpuAvailable +
                ", costPerHr=" + costPerHr +
                ", secureCloud=" + secureCloud +
                '}';
    }
}