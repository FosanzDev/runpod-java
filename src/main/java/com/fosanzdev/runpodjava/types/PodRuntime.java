package com.fosanzdev.runpodjava.types;

import java.util.List;

public class PodRuntime {
    private PodRuntimeContainer container;
    private List<PodRuntimeGpus> gpus;
    private List<PodRuntimePorts> ports;
    private Integer uptimeInSeconds;

    // Getters and Setters
    public PodRuntimeContainer getContainer() { return container; }
    public void setContainer(PodRuntimeContainer container) { this.container = container; }

    public List<PodRuntimeGpus> getGpus() { return gpus; }
    public void setGpus(List<PodRuntimeGpus> gpus) { this.gpus = gpus; }

    public List<PodRuntimePorts> getPorts() { return ports; }
    public void setPorts(List<PodRuntimePorts> ports) { this.ports = ports; }

    public Integer getUptimeInSeconds() { return uptimeInSeconds; }
    public void setUptimeInSeconds(Integer uptimeInSeconds) { this.uptimeInSeconds = uptimeInSeconds; }

    @Override
    public String toString() {
        return "PodRuntime{" +
                "container=" + container +
                ", gpus=" + gpus +
                ", ports=" + ports +
                ", uptimeInSeconds=" + uptimeInSeconds +
                '}';
    }
}