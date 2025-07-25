package com.fosanzdev.runpodjava.types;

public class Gpu {
    private String id;
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