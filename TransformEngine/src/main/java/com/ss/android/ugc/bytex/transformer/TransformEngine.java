package com.ss.android.ugc.bytex.transformer;

import com.android.build.api.transform.Status;
import com.ss.android.ugc.bytex.transformer.cache.FileData;
import com.ss.android.ugc.bytex.transformer.cache.JarCache;
import com.ss.android.ugc.bytex.transformer.concurrent.Schedulers;
import com.ss.android.ugc.bytex.transformer.concurrent.Worker;
import com.ss.android.ugc.bytex.transformer.processor.BackupFileProcessor;
import com.ss.android.ugc.bytex.transformer.processor.FileProcessor;
import com.ss.android.ugc.bytex.transformer.processor.task.PerformTransformTask;
import com.ss.android.ugc.bytex.transformer.processor.task.PerformTraverseTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * Created by tlh on 2018/8/21.
 */

public class TransformEngine {
    private TransformContext context;

    public TransformEngine(TransformContext context) {
        this.context = context;
    }

    /**
     * call internal
     */
    public void markRunningState(TransformContext.State state) {
        context.markRunningState(state);
    }

    public void transform(FileProcessor... processors) {
        transform(false, processors);
    }

    public void transform(boolean isLast, FileProcessor... processors) {
        System.out.println("TransformEngine.transform() called with: isLast = [" + isLast + "], processors = [" + processors + "]");
        Schedulers.FORKJOINPOOL().invoke(new PerformTransformTask(context.allFiles(), getProcessorList(processors), isLast, context));
    }

    public void skip() throws IOException {
        System.out.println("TransformEngine.skip() called");
        Worker worker = Schedulers.IO();
        context.allFiles()
                .map(f -> (Callable<Void>) () -> {
                    f.skip();
                    return null;
                })
                .forEach(worker::submit);
        worker.await();
    }

    public void transformOutput() throws IOException {
        System.out.println("TransformEngine.transformOutput() called");
        Worker worker = Schedulers.IO();
        context.allFiles()
                .filter(fileCache -> !fileCache.isHasWritten())
                .map(f -> (Callable<Void>) () -> {
                    f.transformOutput();
                    return null;
                })
                .forEach(worker::submit);
        worker.await();
    }

    public void traverseOnly(FileProcessor... processors) {
        System.out.println("TransformEngine.traverseOnly() called with: processors = [" + processors + "]");
        Schedulers.FORKJOINPOOL().invoke(new PerformTraverseTask(context.allFiles(), getProcessorList(processors)));
    }

    public void traverseAndroidJar(File jar, FileProcessor... processors) {
        System.out.println("TransformEngine.traverseAndroidJar() called with: jar = [" + jar + "], processors = [" + processors + "]");
        Schedulers.FORKJOINPOOL().invoke(new PerformTraverseTask(Stream.of(new JarCache(jar, context.isIncremental() ? Status.NOTCHANGED : Status.ADDED, context)), getProcessorList(processors)));
    }

    private static List<FileProcessor> getProcessorList(FileProcessor[] processors) {
        List<FileProcessor> realProcessorList = new ArrayList<>(processors.length + 1);
        Collections.addAll(realProcessorList, processors);
        realProcessorList.add(new BackupFileProcessor());
        return realProcessorList;
    }

    public TransformContext getContext() {
        return context;
    }

    public void addFile(String affinity, FileData file) {
        context.addFile(affinity, file);
    }
}
