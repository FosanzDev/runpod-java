package com.fosanzdev.runpodjava.graphql;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class GraphQLRequest {
    private final String query;
    private final Map<String, Object> variables;

    public GraphQLRequest(String query, Map<String, Object> variables) {
        this.query = query;
        this.variables = variables != null ? variables : new HashMap<>();
    }

    public String toJson() {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("query", query);
        requestMap.put("variables", variables);
        return new Gson().toJson(requestMap);
    }
}