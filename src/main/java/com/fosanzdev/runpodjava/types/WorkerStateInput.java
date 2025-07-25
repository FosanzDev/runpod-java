package com.fosanzdev.runpodjava.types;

public class WorkerStateInput {
    private EndpointStatisticGranularity granularity;

    // Constructors
    public WorkerStateInput() {}

    public WorkerStateInput(EndpointStatisticGranularity granularity) {
        this.granularity = granularity;
    }

    // Getters and Setters
    public EndpointStatisticGranularity getGranularity() { return granularity; }
    public void setGranularity(EndpointStatisticGranularity granularity) { this.granularity = granularity; }

    @Override
    public String toString() {
        return "WorkerStateInput{" +
                "granularity=" + granularity +
                '}';
    }
}