package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class Test {
    private String id;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private String githubBuildId;
    private String error;
    private List<Result> results;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public String getGithubBuildId() { return githubBuildId; }
    public void setGithubBuildId(String githubBuildId) { this.githubBuildId = githubBuildId; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public List<Result> getResults() { return results; }
    public void setResults(List<Result> results) { this.results = results; }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", startedAt=" + startedAt +
                ", completedAt=" + completedAt +
                ", error='" + error + '\'' +
                '}';
    }
}