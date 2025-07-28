package com.fosanzdev.runpodjava.operations.queries.pod;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

/**
 * Filter parameters for pod queries.
 */
@GraphQLField(typeName = "PodFilter")
public class PodFilter {
    @GraphQLField(fallbackPriority = 0)
    private String podId;

    // Constructors
    public PodFilter() {}

    public PodFilter(String podId) {
        this.podId = podId;
    }

    // Getters and Setters
    public String getPodId() {
        return podId;
    }

    public void setPodId(String podId) {
        this.podId = podId;
    }

    @Override
    public String toString() {
        return "PodFilter{" +
                "podId='" + podId + '\'' +
                '}';
    }
}