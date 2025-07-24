package com.fosanzdev.runpodjava.graphql;

import java.util.List;

public class GraphQLResponse<T> {
    private T data;
    private List<GraphQLError> errors;

    public static class GraphQLError {
        private String message;
        private List<String> path;
        private Object locations;
        private Object extensions;

        // Getters and setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<String> getPath() {
            return path;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }

        public Object getLocations() {
            return locations;
        }

        public void setLocations(Object locations) {
            this.locations = locations;
        }

        public Object getExtensions() {
            return extensions;
        }

        public void setExtensions(Object extensions) {
            this.extensions = extensions;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GraphQLError{");
            sb.append("message='").append(message).append('\'');
            if (path != null && !path.isEmpty()) {
                sb.append(", path=").append(path);
            }
            if (locations != null) {
                sb.append(", locations=").append(locations);
            }
            if (extensions != null) {
                sb.append(", extensions=").append(extensions);
            }
            sb.append('}');
            return sb.toString();
        }
    }

    // Getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GraphQLError> getErrors() {
        return errors;
    }

    public void setErrors(List<GraphQLError> errors) {
        this.errors = errors;
    }
}