package com.fosanzdev.runpodjava.types;

public class WebhookRequestsInput {
    private EndpointStatisticGranularity granularity;

    // Constructors
    public WebhookRequestsInput() {}

    public WebhookRequestsInput(EndpointStatisticGranularity granularity) {
        this.granularity = granularity;
    }

    // Getters and Setters
    public EndpointStatisticGranularity getGranularity() { return granularity; }
    public void setGranularity(EndpointStatisticGranularity granularity) { this.granularity = granularity; }

    @Override
    public String toString() {
        return "WebhookRequestsInput{" +
                "granularity=" + granularity +
                '}';
    }
}