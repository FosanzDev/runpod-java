package com.fosanzdev.runpodjava.operations.queries.cpu;

import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.RunPodRuntimeException;
import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.types.CpuType;

import java.io.IOException;
import java.util.List;

public class CpuQueries extends BaseRunPodService {

    public CpuQueries(RunPodClient client) {
        super(client);
    }

    /**
     * Get all available CPU types.
     *
     * @return List of CPU types
     * @throws RunPodRuntimeException if the query fails
     */
    public List<CpuType> getCpuTypes() {
        try {
            String query = """
                query cpuTypes {
                  cpuTypes {
                    id
                    displayName
                    manufacturer
                    cores
                    threadsPerCore
                    groupId
                  }
                }
                """;

            CpuTypesResponse response = execute(query, null, CpuTypesResponse.class);
            return response.getCpuTypes();
        } catch (IOException e) {
            throw new RunPodRuntimeException("Failed to retrieve CPU types", e);
        }
    }
}