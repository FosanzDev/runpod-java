package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.util.List;

@GraphQLField(typeName = "DataCenterStorageList")
public class DataCenterStorageList {
    @GraphQLField
    private String mnt;

    @GraphQLField
    private String pw;

    @GraphQLField
    private List<String> servers;

    @GraphQLField
    private String type;

    @GraphQLField
    private List<Integer> versions;

    @GraphQLField
    private boolean primary;

    // Getters and Setters remain unchanged
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