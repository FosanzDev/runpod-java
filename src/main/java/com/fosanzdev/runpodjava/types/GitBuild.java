package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;

public class GitBuild {
    private String id;
    private String commitHash;
    private String commitMessage;
    private String branch;
    private LocalDateTime commitDate;
    private GitBuildState state;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private String error;
    private String repoId;
    private String imageName;
    private Test test;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCommitHash() { return commitHash; }
    public void setCommitHash(String commitHash) { this.commitHash = commitHash; }

    public String getCommitMessage() { return commitMessage; }
    public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public LocalDateTime getCommitDate() { return commitDate; }
    public void setCommitDate(LocalDateTime commitDate) { this.commitDate = commitDate; }

    public GitBuildState getState() { return state; }
    public void setState(GitBuildState state) { this.state = state; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public String getRepoId() { return repoId; }
    public void setRepoId(String repoId) { this.repoId = repoId; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public Test getTest() { return test; }
    public void setTest(Test test) { this.test = test; }

    @Override
    public String toString() {
        return "GitBuild{" +
                "id='" + id + '\'' +
                ", commitHash='" + commitHash + '\'' +
                ", branch='" + branch + '\'' +
                ", state=" + state +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}