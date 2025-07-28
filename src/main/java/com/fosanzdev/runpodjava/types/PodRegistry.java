package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;

@GraphQLField(typeName = "PodRegistry")
public class PodRegistry {
    @GraphQLField(fallbackPriority = 0)
    private String auth;
    
    @GraphQLField(fallbackPriority = 1)
    private String pass;
    
    @GraphQLField(fallbackPriority = 0)
    private String url;
    
    @GraphQLField(fallbackPriority = 0)
    private String user;
    
    @GraphQLField(fallbackPriority = 0)
    private String username;

    // Getters and Setters
    public String getAuth() { return auth; }
    public void setAuth(String auth) { this.auth = auth; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "PodRegistry{" +
                "auth='" + auth + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}