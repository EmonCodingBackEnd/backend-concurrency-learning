package com.coding.concurrency.example.aqs;

import java.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureTaskExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);
        log.info("do something in main");
        Thread.sleep(2000);
        log.info("do something in main done");
        String result = futureTask.get();
        log.info("result:{}", result);
        executorService.shutdown();
    }
}
