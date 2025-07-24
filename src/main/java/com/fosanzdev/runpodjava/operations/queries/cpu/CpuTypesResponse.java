package com.fosanzdev.runpodjava.operations.queries.cpu;

import com.fosanzdev.runpodjava.types.CpuType;

import java.util.List;

public class CpuTypesResponse {
    private List<CpuType> cpuTypes;

    public List<CpuType> getCpuTypes() { return cpuTypes; }
    public void setCpuTypes(List<CpuType> cpuTypes) { this.cpuTypes = cpuTypes; }
}