package com.fosanzdev.runpodjava.internal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger for fallback operations in the RunPod SDK.
 * Provides structured logging for production debugging.
 */
public class FallbackLogger {
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logFallback(String operation, String reason, String fallbackMethod, boolean enabled) {
        if (!enabled) return;

        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        System.err.printf("[RUNPOD-SDK] %s - FALLBACK: %s | Reason: %s | Using: %s%n",
                timestamp, operation, reason, fallbackMethod);
    }

    public static void logFieldMissing(String operation, String fieldName, boolean enabled) {
        if (!enabled) return;

        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        System.err.printf("[RUNPOD-SDK] %s - FIELD_MISSING: %s.%s not available due to server limitations%n",
                timestamp, operation, fieldName);
    }
}