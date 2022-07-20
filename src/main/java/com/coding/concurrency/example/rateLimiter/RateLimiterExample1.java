package com.coding.concurrency.example.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterExample1 {

    // 令牌桶算法
    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            /*if (rateLimiter.tryAcquire(200, TimeUnit.MILLISECONDS)) {
                handle(i);
            }*/
            rateLimiter.acquire();
            handle(i);
        }
    }

    private static void handle(int i) {
        log.info("{}", i);
    }
}
