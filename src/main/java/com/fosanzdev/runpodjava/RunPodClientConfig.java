package com.fosanzdev.runpodjava;

/**
 * Configuration class for RunPod client behavior.
 */
public class RunPodClientConfig {
    private final FallbackStrategy fallbackStrategy;
    private final boolean logFallbacks;

    public enum FallbackStrategy {
        /**
         * Automatically fall back to simpler queries when server errors occur.
         * Tries: Primary → Fallback → Minimal
         * Recommended for production use.
         */
        AUTO,

        /**
         * Always use the most complete query available, fail if it doesn't work.
         * Tries: Primary only
         * Use when you need all data or nothing.
         */
        STRICT,

        /**
         * Always use basic queries to avoid potential server-side issues.
         * Tries: Minimal only
         * Use for maximum reliability with minimal data.
         */
        CONSERVATIVE
    }

    private RunPodClientConfig(Builder builder) {
        this.fallbackStrategy = builder.fallbackStrategy;
        this.logFallbacks = builder.logFallbacks;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static RunPodClientConfig defaultConfig() {
        return builder().build();
    }

    public FallbackStrategy getFallbackStrategy() {
        return fallbackStrategy;
    }

    public boolean shouldLogFallbacks() {
        return logFallbacks;
    }

    public static class Builder {
        private FallbackStrategy fallbackStrategy = FallbackStrategy.AUTO;
        private boolean logFallbacks = true;

        /**
         * Set the fallback strategy for handling server errors.
         * @param strategy The strategy to use
         * @return Builder instance
         */
        public Builder fallbackStrategy(FallbackStrategy strategy) {
            this.fallbackStrategy = strategy;
            return this;
        }

        /**
         * Enable or disable logging of fallback operations.
         * @param log Whether to log fallback operations
         * @return Builder instance
         */
        public Builder logFallbacks(boolean log) {
            this.logFallbacks = log;
            return this;
        }

        public RunPodClientConfig build() {
            return new RunPodClientConfig(this);
        }
    }
}