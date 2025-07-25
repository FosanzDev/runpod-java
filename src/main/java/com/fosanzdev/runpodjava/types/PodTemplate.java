package com.fosanzdev.runpodjava.types;

import java.util.List;

public class PodTemplate {
    private Boolean advancedStart;
    private Integer containerDiskInGb;
    private String containerRegistryAuthId;
    private String dockerArgs;
    private Double earned;
    private List<EnvironmentVariable> env;
    private String id;
    private String imageName;
    private Boolean isPublic;
    private Boolean isRunpod;
    private Boolean isServerless;
    private String boundEndpointId;
    private String name;
    private String ports;
    private List<PortConfig> portsConfig;
    private String readme;
    private Integer runtimeInMin;
    private Boolean startJupyter;
    private String startScript;
    private Boolean startSsh;
    private Integer volumeInGb;
    private String volumeMountPath;
    private Object config; // JSON object
    private String category;
    private String userId;
    private Integer presentationOrder;

    // Getters and Setters
    public Boolean getAdvancedStart() { return advancedStart; }
    public void setAdvancedStart(Boolean advancedStart) { this.advancedStart = advancedStart; }

    public Integer getContainerDiskInGb() { return containerDiskInGb; }
    public void setContainerDiskInGb(Integer containerDiskInGb) { this.containerDiskInGb = containerDiskInGb; }

    public String getContainerRegistryAuthId() { return containerRegistryAuthId; }
    public void setContainerRegistryAuthId(String containerRegistryAuthId) { this.containerRegistryAuthId = containerRegistryAuthId; }

    public String getDockerArgs() { return dockerArgs; }
    public void setDockerArgs(String dockerArgs) { this.dockerArgs = dockerArgs; }

    public Double getEarned() { return earned; }
    public void setEarned(Double earned) { this.earned = earned; }

    public List<EnvironmentVariable> getEnv() { return env; }
    public void setEnv(List<EnvironmentVariable> env) { this.env = env; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public Boolean getIsPublic() { return isPublic; }
    public void setIsPublic(Boolean isPublic) { this.isPublic = isPublic; }

    public Boolean getIsRunpod() { return isRunpod; }
    public void setIsRunpod(Boolean isRunpod) { this.isRunpod = isRunpod; }

    public Boolean getIsServerless() { return isServerless; }
    public void setIsServerless(Boolean isServerless) { this.isServerless = isServerless; }

    public String getBoundEndpointId() { return boundEndpointId; }
    public void setBoundEndpointId(String boundEndpointId) { this.boundEndpointId = boundEndpointId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPorts() { return ports; }
    public void setPorts(String ports) { this.ports = ports; }

    public List<PortConfig> getPortsConfig() { return portsConfig; }
    public void setPortsConfig(List<PortConfig> portsConfig) { this.portsConfig = portsConfig; }

    public String getReadme() { return readme; }
    public void setReadme(String readme) { this.readme = readme; }

    public Integer getRuntimeInMin() { return runtimeInMin; }
    public void setRuntimeInMin(Integer runtimeInMin) { this.runtimeInMin = runtimeInMin; }

    public Boolean getStartJupyter() { return startJupyter; }
    public void setStartJupyter(Boolean startJupyter) { this.startJupyter = startJupyter; }

    public String getStartScript() { return startScript; }
    public void setStartScript(String startScript) { this.startScript = startScript; }

    public Boolean getStartSsh() { return startSsh; }
    public void setStartSsh(Boolean startSsh) { this.startSsh = startSsh; }

    public Integer getVolumeInGb() { return volumeInGb; }
    public void setVolumeInGb(Integer volumeInGb) { this.volumeInGb = volumeInGb; }

    public String getVolumeMountPath() { return volumeMountPath; }
    public void setVolumeMountPath(String volumeMountPath) { this.volumeMountPath = volumeMountPath; }

    public Object getConfig() { return config; }
    public void setConfig(Object config) { this.config = config; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Integer getPresentationOrder() { return presentationOrder; }
    public void setPresentationOrder(Integer presentationOrder) { this.presentationOrder = presentationOrder; }

    @Override
    public String toString() {
        return "PodTemplate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", isPublic=" + isPublic +
                ", isServerless=" + isServerless +
                ", category='" + category + '\'' +
                '}';
    }
}