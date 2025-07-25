package com.fosanzdev.runpodjava.types;

public class PortConfig {
    private String port;
    private String name;

    // Constructors
    public PortConfig() {}

    public PortConfig(String port, String name) {
        this.port = port;
        this.name = name;
    }

    // Getters and Setters
    public String getPort() { return port; }
    public void setPort(String port) { this.port = port; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "PortConfig{" +
                "port='" + port + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}