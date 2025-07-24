package com.fosanzdev.runpodjava;

import java.io.IOException;

/**
 * Custom exception for RunPod API related errors with fallback information.
 */
public class RunPodException extends IOException {
    private final boolean fallbackUsed;
    private final String originalError;
    private final String fallbackMethod;

    public RunPodException(String message) {
        super(message);
        this.fallbackUsed = false;
        this.originalError = null;
        this.fallbackMethod = null;
    }

    public RunPodException(String message, Throwable cause) {
        super(message, cause);
        this.fallbackUsed = false;
        this.originalError = null;
        this.fallbackMethod = null;
    }

    public RunPodException(String message, String originalError, String fallbackMethod) {
        super(message);
        this.fallbackUsed = true;
        this.originalError = originalError;
        this.fallbackMethod = fallbackMethod;
    }

    public boolean wasFallbackUsed() {
        return fallbackUsed;
    }

    public String getOriginalError() {
        return originalError;
    }

    public String getFallbackMethod() {
        return fallbackMethod;
    }
}