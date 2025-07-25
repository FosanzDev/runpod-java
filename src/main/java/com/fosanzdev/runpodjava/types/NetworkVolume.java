package com.fosanzdev.runpodjava.types;

public class NetworkVolume {
    private String id;
    private String name;
    private Integer size;
    private String dataCenterId;
    private DataCenter dataCenter;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getSize() { return size; }
    public void setSize(Integer size) { this.size = size; }

    public String getDataCenterId() { return dataCenterId; }
    public void setDataCenterId(String dataCenterId) { this.dataCenterId = dataCenterId; }

    public DataCenter getDataCenter() { return dataCenter; }
    public void setDataCenter(DataCenter dataCenter) { this.dataCenter = dataCenter; }

    @Override
    public String toString() {
        return "NetworkVolume{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", dataCenterId='" + dataCenterId + '\'' +
                '}';
    }
}