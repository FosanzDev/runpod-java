package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;

public class HubRelease {
    private String id;
    private String name;
    private String tagName;
    private LocalDateTime createdAt;
    private LocalDateTime releasedAt;
    private LocalDateTime updatedAt;
    private String authorName;
    private String authorId;
    private String authorAvatarUrl;
    private String iconUrl;
    private String body;
    private String readme;
    private String branch;
    private String license;
    private Integer deploys;
    private String config;
    private GitBuild build;
    private Listing listing;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getReleasedAt() { return releasedAt; }
    public void setReleasedAt(LocalDateTime releasedAt) { this.releasedAt = releasedAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public String getAuthorAvatarUrl() { return authorAvatarUrl; }
    public void setAuthorAvatarUrl(String authorAvatarUrl) { this.authorAvatarUrl = authorAvatarUrl; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getReadme() { return readme; }
    public void setReadme(String readme) { this.readme = readme; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getLicense() { return license; }
    public void setLicense(String license) { this.license = license; }

    public Integer getDeploys() { return deploys; }
    public void setDeploys(Integer deploys) { this.deploys = deploys; }

    public String getConfig() { return config; }
    public void setConfig(String config) { this.config = config; }

    public GitBuild getBuild() { return build; }
    public void setBuild(GitBuild build) { this.build = build; }

    public Listing getListing() { return listing; }
    public void setListing(Listing listing) { this.listing = listing; }

    @Override
    public String toString() {
        return "HubRelease{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tagName='" + tagName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", deploys=" + deploys +
                '}';
    }
}