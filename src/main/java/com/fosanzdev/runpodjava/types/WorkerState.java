package com.fosanzdev.runpodjava.types;

import java.time.LocalDateTime;

public class WorkerState {
    private LocalDateTime time;
    private Integer initializing;
    private Integer idle;
    private Integer running;
    private Integer throttled;
    private Integer unhealthy;

    // Getters and Setters
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public Integer getInitializing() { return initializing; }
    public void setInitializing(Integer initializing) { this.initializing = initializing; }

    public Integer getIdle() { return idle; }
    public void setIdle(Integer idle) { this.idle = idle; }

    public Integer getRunning() { return running; }
    public void setRunning(Integer running) { this.running = running; }

    public Integer getThrottled() { return throttled; }
    public void setThrottled(Integer throttled) { this.throttled = throttled; }

    public Integer getUnhealthy() { return unhealthy; }
    public void setUnhealthy(Integer unhealthy) { this.unhealthy = unhealthy; }

    @Override
    public String toString() {
        return "WorkerState{" +
                "time=" + time +
                ", initializing=" + initializing +
                ", idle=" + idle +
                ", running=" + running +
                ", throttled=" + throttled +
                ", unhealthy=" + unhealthy +
                '}';
    }
}