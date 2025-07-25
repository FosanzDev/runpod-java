package com.fosanzdev.runpodjava.types;

public class Repo {
    private String repoName;
    private String repoId;
    private String branch;
    private String dockerFilePath;
    private String buildContext;
    private String dockerArgs;
    private String containerRegistryAuthId;

    // Getters and Setters
    public String getRepoName() { return repoName; }
    public void setRepoName(String repoName) { this.repoName = repoName; }

    public String getRepoId() { return repoId; }
    public void setRepoId(String repoId) { this.repoId = repoId; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getDockerFilePath() { return dockerFilePath; }
    public void setDockerFilePath(String dockerFilePath) { this.dockerFilePath = dockerFilePath; }

    public String getBuildContext() { return buildContext; }
    public void setBuildContext(String buildContext) { this.buildContext = buildContext; }

    public String getDockerArgs() { return dockerArgs; }
    public void setDockerArgs(String dockerArgs) { this.dockerArgs = dockerArgs; }

    public String getContainerRegistryAuthId() { return containerRegistryAuthId; }
    public void setContainerRegistryAuthId(String containerRegistryAuthId) { this.containerRegistryAuthId = containerRegistryAuthId; }

    @Override
    public String toString() {
        return "Repo{" +
                "repoName='" + repoName + '\'' +
                ", repoId='" + repoId + '\'' +
                ", branch='" + branch + '\'' +
                ", dockerFilePath='" + dockerFilePath + '\'' +
                '}';
    }
}