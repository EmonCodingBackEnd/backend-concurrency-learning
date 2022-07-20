package com.coding.concurrency.example.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) throws InterruptedException {
        // newCachedThreadPool中的SynchronousQueue在此仅用于阻塞，不会进行何的缓存。
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(30);
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("task:{}", index);
                }
            });
        }
        executorService.shutdown();
    }
}
