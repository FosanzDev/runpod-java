package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class Listing {
    private Integer id;
    private Boolean listed;
    private String repoId;
    private String title;
    private String description;
    private String repoName;
    private String repoOwner;
    private String repoOwnerAvatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastScannedAt;
    private Integer views;
    private Integer stars;
    private Integer deploys;
    private Integer openIssues;
    private Integer watchers;
    private String language;
    private List<String> tags;
    private String category;
    private String type;
    private List<HubRelease> releases;
    private HubRelease listedRelease;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Boolean getListed() { return listed; }
    public void setListed(Boolean listed) { this.listed = listed; }

    public String getRepoId() { return repoId; }
    public void setRepoId(String repoId) { this.repoId = repoId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRepoName() { return repoName; }
    public void setRepoName(String repoName) { this.repoName = repoName; }

    public String getRepoOwner() { return repoOwner; }
    public void setRepoOwner(String repoOwner) { this.repoOwner = repoOwner; }

    public String getRepoOwnerAvatarUrl() { return repoOwnerAvatarUrl; }
    public void setRepoOwnerAvatarUrl(String repoOwnerAvatarUrl) { this.repoOwnerAvatarUrl = repoOwnerAvatarUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getLastScannedAt() { return lastScannedAt; }
    public void setLastScannedAt(LocalDateTime lastScannedAt) { this.lastScannedAt = lastScannedAt; }

    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }

    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }

    public Integer getDeploys() { return deploys; }
    public void setDeploys(Integer deploys) { this.deploys = deploys; }

    public Integer getOpenIssues() { return openIssues; }
    public void setOpenIssues(Integer openIssues) { this.openIssues = openIssues; }

    public Integer getWatchers() { return watchers; }
    public void setWatchers(Integer watchers) { this.watchers = watchers; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<HubRelease> getReleases() { return releases; }
    public void setReleases(List<HubRelease> releases) { this.releases = releases; }

    public HubRelease getListedRelease() { return listedRelease; }
    public void setListedRelease(HubRelease listedRelease) { this.listedRelease = listedRelease; }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", repoName='" + repoName + '\'' +
                ", repoOwner='" + repoOwner + '\'' +
                ", stars=" + stars +
                ", views=" + views +
                '}';
    }
}