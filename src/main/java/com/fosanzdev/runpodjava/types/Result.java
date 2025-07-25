package com.fosanzdev.runpodjava.types;

public class Result {
    private Integer id;
    private String name;
    private String status;
    private String error;
    private Double executionTime;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public Double getExecutionTime() { return executionTime; }
    public void setExecutionTime(Double executionTime) { this.executionTime = executionTime; }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }
}