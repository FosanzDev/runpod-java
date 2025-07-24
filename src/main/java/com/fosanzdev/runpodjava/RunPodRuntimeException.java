package com.fosanzdev.runpodjava;

/**
 * Runtime exception wrapper for RunPod API operations.
 * This allows users to interact with the client without handling IOException on every call.
 */
public class RunPodRuntimeException extends RuntimeException {
    private final boolean fallbackUsed;
    private final String originalError;
    private final String fallbackMethod;

    public RunPodRuntimeException(String message) {
        super(message);
        this.fallbackUsed = false;
        this.originalError = null;
        this.fallbackMethod = null;
    }

    public RunPodRuntimeException(String message, Throwable cause) {
        super(message, cause);
        this.fallbackUsed = false;
        this.originalError = null;
        this.fallbackMethod = null;
    }

    public RunPodRuntimeException(String message, String originalError, String fallbackMethod) {
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