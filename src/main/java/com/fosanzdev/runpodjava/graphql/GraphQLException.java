package com.fosanzdev.runpodjava.graphql;

import java.io.IOException;
import java.util.List;

/**
 * Exception thrown when GraphQL queries return errors.
 * Contains detailed error information for debugging and fallback decisions.
 */
public class GraphQLException extends IOException {
    private final List<GraphQLResponse.GraphQLError> errors;

    public GraphQLException(String message) {
        super(message);
        this.errors = null;
    }

    public GraphQLException(String message, List<GraphQLResponse.GraphQLError> errors) {
        super(message);
        this.errors = errors;
    }

    public List<GraphQLResponse.GraphQLError> getErrors() {
        return errors;
    }

    /**
     * Check if the error is related to a specific field causing server issues.
     */
    public boolean isFieldRelatedError(String fieldName) {
        if (errors == null) return false;

        return errors.stream().anyMatch(error -> {
            if (error.getPath() != null) {
                return error.getPath().contains(fieldName);
            }
            if (error.getMessage() != null) {
                return error.getMessage().contains(fieldName);
            }
            return false;
        });
    }

    /**
     * Check if this is a server-side internal error that might be resolved with fallback.
     */
    public boolean isServerInternalError() {
        if (errors == null) return false;

        return errors.stream().anyMatch(error -> {
            if (error.getExtensions() != null) {
                Object code = ((java.util.Map<?, ?>) error.getExtensions()).get("code");
                return "INTERNAL_SERVER_ERROR".equals(code);
            }
            return error.getMessage() != null &&
                    error.getMessage().contains("Something went wrong");
        });
    }
}