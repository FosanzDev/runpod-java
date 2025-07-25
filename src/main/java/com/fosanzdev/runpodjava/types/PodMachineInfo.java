package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;

public class PodMachineInfo {
    private String id;
    private Double costPerHr;
    private Double currentPricePerGpu;
    private Integer diskMBps;
    private Integer gpuAvailable;
    private String gpuDisplayName;
    private String gpuTypeId;
    private GpuType gpuType;
    private Boolean listed;
    private String location;
    private String machineType;
    private LocalDateTime maintenanceEnd;
    private String maintenanceNote;
    private LocalDateTime maintenanceStart;
    private Integer maxDownloadSpeedMbps;
    private Integer maxUploadSpeedMbps;
    private String note;
    private String podHostId;
    private String runpodIp;
    private Boolean secureCloud;
    private Boolean supportPublicIp;
    private Integer minPodGpuCount;
    private MachineSystem machineSystem;
    private String dataCenterId;
    private String cpuTypeId;
    private CpuType cpuType;
    private Integer cpuCount;
    private Integer vcpuTotal;
    private Double vcpuReserved;
    private Integer memoryTotal;
    private Double memoryReserved;
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