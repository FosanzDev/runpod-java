package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;
import java.util.List;

public class WebhookRequestStatus {
    private LocalDateTime time;
    private List<Integer> responses;

    // Getters and Setters
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public List<Integer> getResponses() { return responses; }
    public void setResponses(List<Integer> responses) { this.responses = responses; }

    @Override
    public String toString() {
        return "WebhookRequestStatus{" +
                "time=" + time +
                ", responses=" + responses +
                '}';
    }
}