package com.fosanzdev.runpodjava.graphql;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class to build GraphQL queries from annotated classes with intelligent fallback support.
 */
public class GraphQLQueryBuilder {

    /**
     * Builds a simple GraphQL query without variables.
     */
    public static String buildQuery(Class<?> clazz, String queryName, String operationName) {
        return buildQuery(clazz, queryName, operationName, new HashSet<>());
    }

    /**
     * Builds a simple GraphQL query without variables with field exclusions.
     */
    public static String buildQuery(Class<?> clazz, String queryName, String operationName, Set<String> excludedFields) {
        String fields = buildFieldsFromClass(clazz, new HashSet<>(), 0, excludedFields);

        return String.format("""
        query %s {
          %s {
            %s
          }
        }
        """, queryName, operationName, fields);
    }

    /**
     * Builds a GraphQL query with variables and field exclusions for fallback.
     */
    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName,
                                                 String variables, Set<String> excludedFields) {
        String fields = buildFieldsFromClass(clazz, new HashSet<>(), 0, excludedFields);

        return String.format("""
            query %s(%s) {
              %s(input: $input) {
                %s
              }
            }
            """, queryName, variables, operationName, fields);
    }

    /**
     * Builds a GraphQL query with variables (no exclusions).
     */
    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName, String variables) {
        return buildQueryWithVariables(clazz, queryName, operationName, variables, new HashSet<>());
    }

    /**
     * Gets a list of fields that can be progressively excluded for fallback, ordered by priority.
     * Returns field paths like "lowestPrice", "nodeGroupDatacenters.storage", etc.
     */
    public static List<String> getFallbackExclusionList(Class<?> clazz) {
        List<FieldInfo> allFields = collectAllFields(clazz, "", new HashSet<>());

        return allFields.stream()
                .filter(f -> f.priority > 0) // Only exclude non-essential fields
                .sorted((f1, f2) -> Integer.compare(f2.priority, f1.priority)) // Higher priority excluded first
                .map(f -> f.path)
                .collect(Collectors.toList());
    }

    /**
     * Collects all fields with their paths and priorities for fallback exclusion.
     */
    private static List<FieldInfo> collectAllFields(Class<?> clazz, String basePath, Set<Class<?>> visited) {
        if (visited.contains(clazz)) {
            return new ArrayList<>();
        }

        visited.add(clazz);
        List<FieldInfo> fieldInfos = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);

            if (annotation != null && annotation.include()) {
                String fieldName = annotation.value().isEmpty() ?
                        convertToGraphQLFieldName(field.getName()) :
                        annotation.value();

                String fullPath = basePath.isEmpty() ? fieldName : basePath + "." + fieldName;

                // Add this field
                fieldInfos.add(new FieldInfo(fullPath, annotation.fallbackPriority()));

                // Add nested fields
                Class<?> fieldType = getFieldClass(field);
                if (hasGraphQLFieldAnnotation(fieldType)) {
                    fieldInfos.addAll(collectAllFields(fieldType, fullPath, new HashSet<>(visited)));
                }
            }
        }

        visited.remove(clazz);
        return fieldInfos;
    }

    /**
     * Builds the fields string from a class using reflection with exclusions.
     */
    private static String buildFieldsFromClass(Class<?> clazz, Set<Class<?>> visited, int depth, Set<String> excludedFields) {
        if (visited.contains(clazz) || depth > 3) {
            return "";
        }

        visited.add(clazz);
        List<String> fieldStrings = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);

            if (annotation != null && annotation.include()) {
                String fieldName = annotation.value().isEmpty() ?
                        convertToGraphQLFieldName(field.getName()) :
                        annotation.value();

                // Skip if this field is excluded
                if (excludedFields.contains(fieldName)) {
                    continue;
                }

                String fieldString = buildFieldString(field, fieldName, visited, depth, excludedFields, "");
                if (!fieldString.isEmpty()) {
                    fieldStrings.add(fieldString);
                }
            }
        }

        visited.remove(clazz);
        return String.join("\n", fieldStrings);
    }

    /**
     * Builds a field string, handling nested objects with exclusions.
     */
    private static String buildFieldString(Field field, String fieldName, Set<Class<?>> visited,
                                           int depth, Set<String> excludedFields, String basePath) {
        Class<?> fieldType = getFieldClass(field);
        String indent = getIndentation(depth + 1);
        String fullPath = basePath.isEmpty() ? fieldName : basePath + "." + fieldName;

        // Handle List types
        if (List.class.isAssignableFrom(field.getType())) {
            if (hasGraphQLFieldAnnotation(fieldType)) {
                // Check if any nested fields of this list type should cause exclusion
                if (shouldExcludeNestedObject(fieldType, fullPath, excludedFields)) {
                    return ""; // Skip this entire field
                }

                String nestedFields = buildFieldsFromClass(fieldType, visited, depth + 1, excludedFields);
                if (!nestedFields.isEmpty()) {
                    return indent + fieldName + " {\n" + nestedFields + "\n" + indent + "}";
                }
            }
            return indent + fieldName;
        }

        // Handle nested objects
        if (hasGraphQLFieldAnnotation(fieldType)) {
            // Check if this nested object should be excluded
            if (shouldExcludeNestedObject(fieldType, fullPath, excludedFields)) {
                return ""; // Skip this entire field
            }

            String nestedFields = buildFieldsFromClass(fieldType, visited, depth + 1, excludedFields);
            if (!nestedFields.isEmpty()) {
                return indent + fieldName + " {\n" + nestedFields + "\n" + indent + "}";
            }
        }

        // Simple field
        return indent + fieldName;
    }

    /**
     * Checks if a nested object should be excluded based on excluded field paths.
     */
    private static boolean shouldExcludeNestedObject(Class<?> fieldType, String fullPath, Set<String> excludedFields) {
        // Check if the object itself is excluded
        if (excludedFields.contains(fullPath)) {
            return true;
        }

        // Check if all fields of this object are excluded
        Field[] nestedFields = fieldType.getDeclaredFields();
        boolean hasIncludedField = false;

        for (Field nestedField : nestedFields) {
            GraphQLField annotation = nestedField.getAnnotation(GraphQLField.class);
            if (annotation != null && annotation.include()) {
                String nestedFieldName = annotation.value().isEmpty() ?
                        convertToGraphQLFieldName(nestedField.getName()) :
                        annotation.value();
                String nestedFullPath = fullPath + "." + nestedFieldName;

                if (!excludedFields.contains(nestedFullPath)) {
                    hasIncludedField = true;
                    break;
                }
            }
        }

        return !hasIncludedField;
    }

    /**
     * Gets the actual class for a field, handling generics.
     */
    private static Class<?> getFieldClass(Field field) {
        Class<?> fieldType = field.getType();

        if (List.class.isAssignableFrom(fieldType)) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Type[] typeArgs = paramType.getActualTypeArguments();
                if (typeArgs.length > 0) {
                    return (Class<?>) typeArgs[0];
                }
            }
        }

        return fieldType;
    }

    private static String getIndentation(int depth) {
        return "  ".repeat(Math.max(0, depth));
    }

    private static boolean hasGraphQLFieldAnnotation(Class<?> clazz) {
        return clazz.isAnnotationPresent(GraphQLField.class);
    }

    private static String convertToGraphQLFieldName(String javaFieldName) {
        return javaFieldName;
    }

    /**
     * Helper class to store field information for fallback exclusion.
     */
    private static class FieldInfo {
        final String path;
        final int priority;

        FieldInfo(String path, int priority) {
            this.path = path;
            this.priority = priority;
        }
    }
}