package com.fosanzdev.runpodjava.operations.queries.gpu;

import com.fosanzdev.runpodjava.types.GpuType;

import java.util.List;

public class GpuTypesResponse {
    private List<GpuType> gpuTypes;

    public List<GpuType> getGpuTypes() { return gpuTypes; }
    public void setGpuTypes(List<GpuType> gpuTypes) { this.gpuTypes = gpuTypes; }
}