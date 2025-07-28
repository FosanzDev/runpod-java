package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.time.LocalDateTime;
import java.util.List;

@GraphQLField(typeName = "Endpoint")
public class Endpoint {
    @GraphQLField(fallbackPriority = 5)
    private String aiKey;
    
    @GraphQLField(fallbackPriority = 5)
    private String gpuIds;
    
    @GraphQLField(fallbackPriority = 0)
    private String id;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer idleTimeout;
    
    @GraphQLField(fallbackPriority = 0)
    private String name;
    
    @GraphQLField(fallbackPriority = 1)
    private String networkVolumeId;
    
    @GraphQLField(fallbackPriority = 1)
    private String locations;
    
    @GraphQLField(fallbackPriority = 5)
    private List<Pod> pods;
    
    @GraphQLField(fallbackPriority = 1)
    private String scalerType;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer scalerValue;
    
    @GraphQLField(fallbackPriority = 5)
    private PodTemplate template;
    
    @GraphQLField(fallbackPriority = 1)
    private String templateId;
    
    @GraphQLField(fallbackPriority = 0)
    private String type;
    
    @GraphQLField(fallbackPriority = 1)
    private String userId;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer version;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer workersMax;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer workersMin;
    
    @GraphQLField(fallbackPriority = 1)
    private Integer workersStandby;
    
    @GraphQLField(fallbackPriority = 5)
    private Integer workersPFBTarget;
    
    @GraphQLField(fallbackPriority = 0)
    private Integer gpuCount;
    
    @GraphQLField(fallbackPriority = 5)
    private List<EnvironmentVariable> env;
    
    @GraphQLField(fallbackPriority = 1)
    private LocalDateTime createdAt;
    
    @GraphQLField(fallbackPriority = 5)
    private String allowedCudaVersions;
    
    @GraphQLField(fallbackPriority = 5)
    private Integer executionTimeoutMs;
    
    @GraphQLField(fallbackPriority = 5)
    private List<String> instanceIds;
    
    @GraphQLField(fallbackPriority = 1)
    private String computeType;
    
    @GraphQLField(fallbackPriority = 5)
    private List<GitBuild> builds;
    
    @GraphQLField(fallbackPriority = 5)
    private String activeBuildid;
    
    @GraphQLField(fallbackPriority = 5)
    private Repo repo;
    
    @GraphQLField(fallbackPriority = 5)
    private HubRelease hubRelease;
    
    @GraphQLField(fallbackPriority = 5)
    private String idePodId;
    
    @GraphQLField(fallbackPriority = 5)
    private List<WorkerState> workerState;
    
    @GraphQLField(fallbackPriority = 5)
    private List<WebhookRequestStatus> webhookRequests;
    
    @GraphQLField(fallbackPriority = 5)
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