package com.fosanzdev.runpodjava.types;

import java.util.List;

public class DataCenterStorageList {
    private String mnt;
    private String pw;
    private List<String> servers;
    private String type;
    private List<Integer> versions;
    private boolean primary;

    // Getters and Setters
    public String getMnt() { return mnt; }
    public void setMnt(String mnt) { this.mnt = mnt; }

    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }

    public List<String> getServers() { return servers; }
    public void setServers(List<String> servers) { this.servers = servers; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Integer> getVersions() { return versions; }
    public void setVersions(List<Integer> versions) { this.versions = versions; }

    public boolean isPrimary() { return primary; }
    public void setPrimary(boolean primary) { this.primary = primary; }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.types.DataCenterStorageList{" +
                "mnt='" + mnt + '\'' +
                ", pw='" + pw + '\'' +
                ", servers=" + servers +
                ", type='" + type + '\'' +
                ", versions=" + versions +
                ", primary=" + primary +
                '}';
    }
}