package com.fosanzdev.runpodjava.graphql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark fields that should be included in GraphQL queries.
 * When used on a class, it indicates the GraphQL type name.
 * When used on fields, it indicates they should be included in queries.
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GraphQLField {
    /**
     * The GraphQL field name. If empty, uses the Java field name.
     */
    String value() default "";

    /**
     * Whether this field should be included by default in queries.
     */
    boolean include() default true;

    /**
     * The GraphQL type name (used on class level).
     */
    String typeName() default "";
}