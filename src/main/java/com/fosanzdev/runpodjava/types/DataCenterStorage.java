package com.fosanzdev.runpodjava.types;

import java.util.List;

public class DataCenterStorage {
    private String hostname;
    private List<String> ips;
    private String pw;
    private String type;
    private String user;
    private List<DataCenterStorageList> list;

    // Getters and Setters
    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public List<String> getIps() { return ips; }
    public void setIps(List<String> ips) { this.ips = ips; }

    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public List<DataCenterStorageList> getList() { return list; }
    public void setList(List<DataCenterStorageList> list) { this.list = list; }

    @Override
    public String toString() {
        return "com.fosanzdev.runpodjava.types.DataCenterStorage{" +
                "hostname='" + hostname + '\'' +
                ", ips=" + ips +
                ", pw='" + pw + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", list=" + list +
                '}';
    }
}