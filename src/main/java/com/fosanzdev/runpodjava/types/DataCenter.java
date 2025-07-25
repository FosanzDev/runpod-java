package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.util.List;

@GraphQLField(typeName = "DataCenter")
public class DataCenter {
    @GraphQLField
    private String id;

    @GraphQLField
    private String name;

    @GraphQLField
    private String location;

    @GraphQLField
    private DataCenterStorage storage;

    @GraphQLField
    private boolean globalNetwork;

    @GraphQLField
    private boolean storageSupport;

    @GraphQLField
    private boolean listed;

    @GraphQLField
    private List<GpuAvailability> gpuAvailability;

    @GraphQLField
    private List<String> compliance;

    // Getters and Setters remain unchanged
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public DataCenterStorage getStorage() { return storage; }
    public void setStorage(DataCenterStorage storage) { this.storage = storage; }

    public boolean isGlobalNetwork() { return globalNetwork; }
    public void setGlobalNetwork(boolean globalNetwork) { this.globalNetwork = globalNetwork; }

    public boolean isStorageSupport() { return storageSupport; }
    public void setStorageSupport(boolean storageSupport) { this.storageSupport = storageSupport; }

    public boolean isListed() { return listed; }
    public void setListed(boolean listed) { this.listed = listed; }

    public List<GpuAvailability> getGpuAvailability() { return gpuAvailability; }
    public void setGpuAvailability(List<GpuAvailability> gpuAvailability) { this.gpuAvailability = gpuAvailability; }

    public List<String> getCompliance() { return compliance; }
    public void setCompliance(List<String> compliance) { this.compliance = compliance; }

    @Override
    public String toString() {
        return "DataCenter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", storage=" + storage +
                ", globalNetwork=" + globalNetwork +
                ", storageSupport=" + storageSupport +
                ", listed=" + listed +
                ", gpuAvailability=" + gpuAvailability +
                ", compliance=" + compliance +
                '}';
    }
}