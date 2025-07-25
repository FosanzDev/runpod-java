package com.fosanzdev.runpodjava.graphql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GraphQLField {
    String value() default "";
    String typeName() default "";
    boolean include() default true;

    /**
     * Priority for fallback exclusion. Higher values are excluded first.
     * 0 = Essential field (never excluded)
     * 1 = Important field (excluded last)
     * 5 = Normal field
     * 10 = Optional field (excluded first)
     */
    int fallbackPriority() default 5;
}