package com.coding.concurrency.example.aqs;

import java.util.Random;
import java.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;

/**
 * 循环屏障
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static final int threadCount = 20;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            // 随机的时间，触发一个线程
            final int time = new Random().nextInt(1000);
            Thread.sleep(time);
            log.info("随机的时间，触发一个线程 time={}", time);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    log.error("InterruptedException", e);
                } catch (BrokenBarrierException e) {
                    log.error("BrokenBarrierException", e);
                } catch (TimeoutException e) {
                    log.error("TimeoutException", e);
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        log.info("{} is ready", threadNum);
        try {
            // 对每个线程来说，都尝试等待2.5秒，看能否等来5个伙伴！
            cyclicBarrier.await(2500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            return;
        }
        log.info("{} continue", threadNum);
    }
}
