package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class Endpoint {
    private String aiKey;
    private String gpuIds;
    private String id;
    private Integer idleTimeout;
    private String name;
    private String networkVolumeId;
    private String locations;
    private List<Pod> pods;
    private String scalerType;
    private Integer scalerValue;
    private PodTemplate template;
    private String templateId;
    private String type;
    private String userId;
    private Integer version;
    private Integer workersMax;
    private Integer workersMin;
    private Integer workersStandby;
    private Integer workersPFBTarget;
    private Integer gpuCount;
    private List<EnvironmentVariable> env;
    private LocalDateTime createdAt;
    private String allowedCudaVersions;
    private Integer executionTimeoutMs;
    private List<String> instanceIds;
    private String computeType;
    private List<GitBuild> builds;
    private String activeBuildid;
    private Repo repo;
    private HubRelease hubRelease;
    private String idePodId;
    private List<WorkerState> workerState;
    private List<WebhookRequestStatus> webhookRequests;
    private NetworkVolume networkVolume;

    // Getters and Setters
    public String getAiKey() { return aiKey; }
    public void setAiKey(String aiKey) { this.aiKey = aiKey; }

    public String getGpuIds() { return gpuIds; }
    public void setGpuIds(String gpuIds) { this.gpuIds = gpuIds; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Integer getIdleTimeout() { return idleTimeout; }
    public void setIdleTimeout(Integer idleTimeout) { this.idleTimeout = idleTimeout; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNetworkVolumeId() { return networkVolumeId; }
    public void setNetworkVolumeId(String networkVolumeId) { this.networkVolumeId = networkVolumeId; }

    public String getLocations() { return locations; }
    public void setLocations(String locations) { this.locations = locations; }

    public List<Pod> getPods() { return pods; }
    public void setPods(List<Pod> pods) { this.pods = pods; }

    public String getScalerType() { return scalerType; }
    public void setScalerType(String scalerType) { this.scalerType = scalerType; }

    public Integer getScalerValue() { return scalerValue; }
    public void setScalerValue(Integer scalerValue) { this.scalerValue = scalerValue; }

    public PodTemplate getTemplate() { return template; }
    public void setTemplate(PodTemplate template) { this.template = template; }

    public String getTemplateId() { return templateId; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }

    public Integer getWorkersMax() { return workersMax; }
    public void setWorkersMax(Integer workersMax) { this.workersMax = workersMax; }

    public Integer getWorkersMin() { return workersMin; }
    public void setWorkersMin(Integer workersMin) { this.workersMin = workersMin; }

    public Integer getWorkersStandby() { return workersStandby; }
    public void setWorkersStandby(Integer workersStandby) { this.workersStandby = workersStandby; }

    public Integer getWorkersPFBTarget() { return workersPFBTarget; }
    public void setWorkersPFBTarget(Integer workersPFBTarget) { this.workersPFBTarget = workersPFBTarget; }

    public Integer getGpuCount() { return gpuCount; }
    public void setGpuCount(Integer gpuCount) { this.gpuCount = gpuCount; }

    public List<EnvironmentVariable> getEnv() { return env; }
    public void setEnv(List<EnvironmentVariable> env) { this.env = env; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getAllowedCudaVersions() { return allowedCudaVersions; }
    public void setAllowedCudaVersions(String allowedCudaVersions) { this.allowedCudaVersions = allowedCudaVersions; }

    public Integer getExecutionTimeoutMs() { return executionTimeoutMs; }
    public void setExecutionTimeoutMs(Integer executionTimeoutMs) { this.executionTimeoutMs = executionTimeoutMs; }

    public List<String> getInstanceIds() { return instanceIds; }
    public void setInstanceIds(List<String> instanceIds) { this.instanceIds = instanceIds; }

    public String getComputeType() { return computeType; }
    public void setComputeType(String computeType) { this.computeType = computeType; }

    public List<GitBuild> getBuilds() { return builds; }
    public void setBuilds(List<GitBuild> builds) { this.builds = builds; }

    public String getActiveBuildid() { return activeBuildid; }
    public void setActiveBuildid(String activeBuildid) { this.activeBuildid = activeBuildid; }

    public Repo getRepo() { return repo; }
    public void setRepo(Repo repo) { this.repo = repo; }

    public HubRelease getHubRelease() { return hubRelease; }
    public void setHubRelease(HubRelease hubRelease) { this.hubRelease = hubRelease; }

    public String getIdePodId() { return idePodId; }
    public void setIdePodId(String idePodId) { this.idePodId = idePodId; }

    public List<WorkerState> getWorkerState() { return workerState; }
    public void setWorkerState(List<WorkerState> workerState) { this.workerState = workerState; }

    public List<WebhookRequestStatus> getWebhookRequests() { return webhookRequests; }
    public void setWebhookRequests(List<WebhookRequestStatus> webhookRequests) { this.webhookRequests = webhookRequests; }

    public NetworkVolume getNetworkVolume() { return networkVolume; }
    public void setNetworkVolume(NetworkVolume networkVolume) { this.networkVolume = networkVolume; }

    @Override
    public String toString() {
        return "Endpoint{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", scalerType='" + scalerType + '\'' +
                ", scalerValue=" + scalerValue +
                ", workersMax=" + workersMax +
                ", workersMin=" + workersMin +
                ", gpuCount=" + gpuCount +
                '}';
    }
}