package com.fosanzdev.runpodjava.graphql;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class to build GraphQL queries from annotated classes with intelligent fallback and depth limit support.
 */
public class GraphQLQueryBuilder {

    private static final int DEFAULT_MAX_DEPTH = 3;
    private static final int DEFAULT_FALLBACK_THRESHOLD = 0;

    // === PUBLIC METHODS ===

    public static String buildQuery(Class<?> clazz, String queryName, String operationName) {
        return buildQuery(clazz, queryName, operationName, new HashSet<>(), DEFAULT_MAX_DEPTH, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQuery(Class<?> clazz, String queryName, String operationName, Set<String> excludedFields) {
        return buildQuery(clazz, queryName, operationName, excludedFields, DEFAULT_MAX_DEPTH, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQuery(Class<?> clazz, String queryName, String operationName, Set<String> excludedFields, int maxDepth) {
        return buildQuery(clazz, queryName, operationName, excludedFields, maxDepth, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQuery(Class<?> clazz, String queryName, String operationName, Set<String> excludedFields, int maxDepth, int fallbackThreshold) {
        String fields = buildFieldsFromClass(clazz, new HashSet<>(), 0, excludedFields, "", maxDepth, fallbackThreshold);
        return String.format("""
        query %s {
          %s {
            %s
          }
        }
        """, queryName, operationName, fields);
    }

    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName, String variables) {
        return buildQueryWithVariables(clazz, queryName, operationName, variables, new HashSet<>(), DEFAULT_MAX_DEPTH, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName,
                                                 String variables, Set<String> excludedFields) {
        return buildQueryWithVariables(clazz, queryName, operationName, variables, excludedFields, DEFAULT_MAX_DEPTH, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName,
                                                 String variables, Set<String> excludedFields, int maxDepth) {
        return buildQueryWithVariables(clazz, queryName, operationName, variables, excludedFields, maxDepth, DEFAULT_FALLBACK_THRESHOLD);
    }

    public static String buildQueryWithVariables(Class<?> clazz, String queryName, String operationName,
                                                 String variables, Set<String> excludedFields, int maxDepth, int fallbackThreshold) {
        String fields = buildFieldsFromClass(clazz, new HashSet<>(), 0, excludedFields, "", maxDepth, fallbackThreshold);
        return String.format("""
        query %s(%s) {
          %s(input: $input) {
            %s
          }
        }
        """, queryName, variables, operationName, fields);
    }

    public static List<String> getFallbackExclusionList(Class<?> clazz) {
        List<FieldInfo> allFields = collectAllFields(clazz, new HashSet<>());
        return allFields.stream()
                .filter(f -> f.priority > 0)
                .sorted((f1, f2) -> Integer.compare(f2.priority, f1.priority))
                .map(f -> f.path)
                .collect(Collectors.toList());
    }

    // === PRIVATE METHODS ===

    private static boolean isPrimitiveOrWrapper(Class<?> type) {
        return type.isPrimitive() ||
                type == Boolean.class ||
                type == Byte.class ||
                type == Character.class ||
                type == Short.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Float.class ||
                type == Double.class ||
                type == String.class ||
                type.isEnum();
    }

    private static List<FieldInfo> collectAllFields(Class<?> clazz, Set<Class<?>> visited) {
        return collectAllFields(clazz, "", visited, 0, DEFAULT_MAX_DEPTH, GraphQLQueryBuilder.DEFAULT_FALLBACK_THRESHOLD);
    }

    private static List<FieldInfo> collectAllFields(Class<?> clazz, String basePath, Set<Class<?>> visited, int depth, int maxDepth, int fallbackThreshold) {
        if (visited.contains(clazz) || depth >= maxDepth) {
            return new ArrayList<>();
        }

        visited.add(clazz);
        List<FieldInfo> fieldInfos = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);

            if (annotation != null && annotation.include()) {
                if (annotation.fallbackPriority() > fallbackThreshold) continue;

                String fieldName = annotation.value().isEmpty()
                        ? convertToGraphQLFieldName(field.getName())
                        : annotation.value();

                String fullPath = basePath.isEmpty() ? fieldName : basePath + "." + fieldName;

                fieldInfos.add(new FieldInfo(fullPath, annotation.fallbackPriority()));

                Class<?> fieldType = getFieldClass(field);
                if (hasGraphQLFieldAnnotation(fieldType)) {
                    fieldInfos.addAll(collectAllFields(fieldType, fullPath, new HashSet<>(visited), depth + 1, maxDepth, fallbackThreshold));
                }
            }
        }

        visited.remove(clazz);
        return fieldInfos;
    }

    private static String buildFieldsFromClass(Class<?> clazz, Set<String> visitedPaths, int depth,
                                               Set<String> excludedFields, String currentPath, int maxDepth,
                                               int fallbackThreshold) {
        if (visitedPaths.contains(currentPath) || depth >= maxDepth) {
            return "";
        }

        visitedPaths.add(currentPath);
        List<String> fieldStrings = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);
            if (annotation != null && annotation.include()) {
                if (annotation.fallbackPriority() > fallbackThreshold) continue;

                String fieldName = annotation.value().isEmpty()
                        ? convertToGraphQLFieldName(field.getName())
                        : annotation.value();

                String fullPath = currentPath.isEmpty() ? fieldName : currentPath + "." + fieldName;

                if (excludedFields.contains(fieldName) || excludedFields.contains(fullPath)) {
                    continue;
                }

                String fieldString = buildFieldString(field, fieldName, visitedPaths, depth, excludedFields, currentPath, maxDepth, fallbackThreshold);
                if (!fieldString.isEmpty()) {
                    fieldStrings.add(fieldString);
                }
            }
        }

        visitedPaths.remove(currentPath);
        return String.join("\n", fieldStrings);
    }

    private static String buildFieldString(Field field, String fieldName, Set<String> visitedPaths,
                                           int depth, Set<String> excludedFields, String basePath,
                                           int maxDepth, int fallbackThreshold) {
        String indent = getIndentation(depth + 1);
        String fullPath = basePath.isEmpty() ? fieldName : basePath + "." + fieldName;

        Class<?> rawFieldType = field.getType();
        Class<?> elementType = getFieldElementType(field);

        // Handle List types
        if (List.class.isAssignableFrom(rawFieldType)) {
            if (elementType != null && hasGraphQLFieldAnnotation(elementType)) {
                if (shouldExcludeNestedObject(elementType, fullPath, excludedFields, fallbackThreshold)) {
                    return "";
                }

                if (depth + 1 >= maxDepth) {
                    return ""; // Skip complex lists at max depth
                }

                String nestedFields = buildFieldsFromClass(elementType, visitedPaths, depth + 1, excludedFields, fullPath, maxDepth, fallbackThreshold);
                if (!nestedFields.isEmpty()) {
                    return indent + fieldName + " {\n" + nestedFields + "\n" + indent + "}";
                } else {
                    return ""; // List of complex objects but no valid subfields
                }
            } else {
                // List of primitives - check if the element type is actually primitive
                if (elementType != null && isPrimitiveOrWrapper(elementType)) {
                    return indent + fieldName;
                } else {
                    // Unknown or complex list type without annotations - skip to be safe
                    return "";
                }
            }
        }

        // Handle complex object types
        if (hasGraphQLFieldAnnotation(rawFieldType)) {
            if (shouldExcludeNestedObject(rawFieldType, fullPath, excludedFields, fallbackThreshold)) {
                return "";
            }

            if (depth + 1 >= maxDepth) {
                return ""; // Skip complex objects at max depth
            }

            String nestedFields = buildFieldsFromClass(rawFieldType, visitedPaths, depth + 1, excludedFields, fullPath, maxDepth, fallbackThreshold);
            if (!nestedFields.isEmpty()) {
                return indent + fieldName + " {\n" + nestedFields + "\n" + indent + "}";
            } else {
                return ""; // Complex object but no valid subfields
            }
        }

        // Handle definite primitive types
        if (isPrimitiveOrWrapper(rawFieldType)) {
            return indent + fieldName;
        }

        return "";
    }

    private static boolean shouldExcludeNestedObject(Class<?> fieldType, String fullPath, Set<String> excludedFields, int fallbackThreshold) {
        if (excludedFields.contains(fullPath)) {
            return true;
        }

        for (Field nestedField : fieldType.getDeclaredFields()) {
            GraphQLField annotation = nestedField.getAnnotation(GraphQLField.class);
            if (annotation != null && annotation.include() && annotation.fallbackPriority() <= fallbackThreshold) {
                String nestedFieldName = annotation.value().isEmpty()
                        ? convertToGraphQLFieldName(nestedField.getName())
                        : annotation.value();
                String nestedFullPath = fullPath + "." + nestedFieldName;
                if (!excludedFields.contains(nestedFullPath)) {
                    return false; // Found at least one valid field, don't exclude the object
                }
            }
        }

        return true; // No valid fields found, exclude the object
    }

    private static Class<?> getFieldClass(Field field) {
        if (List.class.isAssignableFrom(field.getType())) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) genericType).getActualTypeArguments();
                if (actualTypes.length == 1 && actualTypes[0] instanceof Class) {
                    return (Class<?>) actualTypes[0];
                }
            }
            return Object.class;
        } else {
            return field.getType();
        }
    }

    private static Class<?> getFieldElementType(Field field) {
        if (List.class.isAssignableFrom(field.getType())) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type[] typeArgs = ((ParameterizedType) genericType).getActualTypeArguments();
                if (typeArgs.length == 1) {
                    Type arg = typeArgs[0];
                    if (arg instanceof Class<?>) {
                        return (Class<?>) arg;
                    }
                    if (arg instanceof ParameterizedType) {
                        return (Class<?>) ((ParameterizedType) arg).getRawType();
                    }
                }
            }
        }
        return field.getType();
    }

    private static boolean hasGraphQLFieldAnnotation(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);
            if (annotation != null && annotation.include()) {
                return true;
            }
        }
        return false;
    }

    private static String convertToGraphQLFieldName(String javaFieldName) {
        return javaFieldName;
    }

    private static String getIndentation(int depth) {
        return "  ".repeat(Math.max(0, depth));
    }

    private record FieldInfo(String path, int priority) {
    }
}
