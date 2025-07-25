package com.fosanzdev.runpodjava.operations.queries;

import com.fosanzdev.runpodjava.internal.BaseRunPodService;
import com.fosanzdev.runpodjava.RunPodClient;
import com.fosanzdev.runpodjava.operations.queries.cpu.CpuQueries;
import com.fosanzdev.runpodjava.operations.queries.gpu.GpuQueries;
import com.fosanzdev.runpodjava.operations.queries.pod.PodQueries;

public class Queries extends BaseRunPodService {

    public final CpuQueries cpu;
    public final GpuQueries gpu;
    public final PodQueries pod;

    public Queries(RunPodClient client) {
        super(client);
        this.cpu = new CpuQueries(client);
        this.gpu = new GpuQueries(client);
        this.pod = new PodQueries(client);
    }
}