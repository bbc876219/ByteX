package com.ss.android.ugc.bytex.transformer.processor.task;

import com.ss.android.ugc.bytex.transformer.cache.FileCache;
import com.ss.android.ugc.bytex.transformer.processor.FileProcessor;
import com.ss.android.ugc.bytex.transformer.utils.FetchStackTrace;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PerformTraverseTask extends RecursiveAction {
    private final Stream<FileCache> source;
    private final List<FileProcessor> processors;

    public PerformTraverseTask(Stream<FileCache> source, List<FileProcessor> processors) {
        this.source = source;
        this.processors = processors;
        System.out.println("PerformTraverseTask.PerformTraverseTask() called with: source = [" + source + "], processors = [" + processors + "]\n"+FetchStackTrace.getStackTraceString(new Throwable()));
    }

    @Override
    protected void compute() {
        System.out.println("PerformTraverseTask.compute() called\n"+ FetchStackTrace.getStackTraceString(new Throwable()));
        List<FileTraverseTask> tasks = source.map(cache -> new FileTraverseTask(cache, processors)).collect(Collectors.toList());
        invokeAll(tasks);
    }
}
