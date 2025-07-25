package com.fosanzdev.runpodjava.graphql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Utility class to build GraphQL queries from annotated classes.
 */
public class GraphQLQueryBuilder {

    /**
     * Builds a GraphQL query for the given class using reflection.
     *
     * @param clazz The class to inspect for GraphQL fields
     * @param queryName The name of the GraphQL query
     * @param operationName The name of the GraphQL operation (e.g., "cpuTypes")
     * @return The generated GraphQL query string
     */
    public static String buildQuery(Class<?> clazz, String queryName, String operationName) {
        String fields = buildFieldsFromClass(clazz);

        return String.format("""
            query %s {
              %s {
                %s
              }
            }
            """, queryName, operationName, fields);
    }

    /**
     * Builds a GraphQL query with variables.
     */
    public static String buildQuery(Class<?> clazz, String queryName, String operationName, String variables) {
        String fields = buildFieldsFromClass(clazz);

        return String.format("""
            query %s(%s) {
              %s {
                %s
              }
            }
            """, queryName, variables, operationName, fields);
    }

    /**
     * Builds the fields string from a class using reflection.
     */
    private static String buildFieldsFromClass(Class<?> clazz) {
        List<String> fieldNames = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            GraphQLField annotation = field.getAnnotation(GraphQLField.class);

            // If field has @GraphQLField annotation and should be included
            if (annotation != null && annotation.include()) {
                String fieldName = annotation.value().isEmpty() ?
                        convertToGraphQLFieldName(field.getName()) :
                        annotation.value();
                fieldNames.add(fieldName);
            }
            // If no annotation but it's a simple field, include it by default
            else if (annotation == null && isSimpleField(field)) {
                fieldNames.add(convertToGraphQLFieldName(field.getName()));
            }
        }

        return String.join("\n    ", fieldNames);
    }

    /**
     * Converts Java field name to GraphQL field name (camelCase).
     */
    private static String convertToGraphQLFieldName(String javaFieldName) {
        // For now, just return as-is since your fields are already in camelCase
        return javaFieldName;
    }

    /**
     * Checks if a field is a simple type that should be included by default.
     */
    private static boolean isSimpleField(Field field) {
        Class<?> type = field.getType();
        return type.isPrimitive() ||
                type == String.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Double.class ||
                type == Float.class ||
                type == Boolean.class;
    }
}