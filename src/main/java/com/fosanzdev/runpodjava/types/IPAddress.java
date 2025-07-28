package com.fosanzdev.runpodjava.types;

import com.fosanzdev.runpodjava.graphql.GraphQLField;
import java.util.List;

@GraphQLField(typeName = "IPAddress")
public class IPAddress {
    @GraphQLField(fallbackPriority = 0)
    private String id;
    
    @GraphQLField(fallbackPriority = 0)
    private String address;
    
    @GraphQLField(fallbackPriority = 1)
    private String networkRangeId;
    
    @GraphQLField(fallbackPriority = 5)
    private NetworkRange networkRange;
    
    @GraphQLField(fallbackPriority = 5)
    private Pod pod;
    
    @GraphQLField(fallbackPriority = 5)
    private List<PodnetNode> podnetNodes;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getNetworkRangeId() { return networkRangeId; }
    public void setNetworkRangeId(String networkRangeId) { this.networkRangeId = networkRangeId; }

    public NetworkRange getNetworkRange() { return networkRange; }
    public void setNetworkRange(NetworkRange networkRange) { this.networkRange = networkRange; }

    public Pod getPod() { return pod; }
    public void setPod(Pod pod) { this.pod = pod; }

    public List<PodnetNode> getPodnetNodes() { return podnetNodes; }
    public void setPodnetNodes(List<PodnetNode> podnetNodes) { this.podnetNodes = podnetNodes; }

    @Override
    public String toString() {
        return "IPAddress{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", networkRangeId='" + networkRangeId + '\'' +
                '}';
    }
}