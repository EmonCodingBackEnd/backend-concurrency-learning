package com.coding.concurrency.example.aqs;

import java.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(2000);
        log.info("do something in main done");
        String result = future.get();
        log.info("result:{}", result);
    }
}
