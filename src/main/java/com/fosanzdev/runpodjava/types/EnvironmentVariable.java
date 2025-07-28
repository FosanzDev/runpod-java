package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "EnvironmentVariable")
public class EnvironmentVariable {

    @GraphQLField(fallbackPriority = 0)
    private String key;

    @GraphQLField(fallbackPriority = 0)
    private String value;

    // Constructors
    public EnvironmentVariable() {}

    public EnvironmentVariable(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters and Setters
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @Override
    public String toString() {
        return "EnvironmentVariable{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}