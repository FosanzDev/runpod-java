package com.fosanzdev.runpodjava.types;

import java.util.List;

public class DataCenter {
    private String id;
    private String name;
    private String location;
    private DataCenterStorage storage;
    private boolean globalNetwork;
    private boolean storageSupport;
    private boolean listed;
    private List<GpuAvailability> gpuAvailability;
    private List<String> compliance;

    // Getters and Setters
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
}