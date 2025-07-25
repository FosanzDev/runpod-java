package com.fosanzdev.runpodjava.types;

public class PodRegistry {
    private String auth;
    private String pass;
    private String url;
    private String user;
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