package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

public class Gpu {

    @GraphQLField(fallbackPriority = 0)
    private String id;

    @GraphQLField(fallbackPriority = 1)
    private String podId;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPodId() { return podId; }
    public void setPodId(String podId) { this.podId = podId; }

    @Override
    public String toString() {
        return "Gpu{" +
                "id='" + id + '\'' +
                ", podId='" + podId + '\'' +
                '}';
    }
}