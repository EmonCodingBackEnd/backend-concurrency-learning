/*
 * 文件名称：ConcurrencyTest.java 系统名称：[系统名称] 模块名称：[模块名称] 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights
 * Reserved. 功能说明：[请在此处输入功能说明] 开发人员：Rushing0711 创建日期：20180324 07:52 修改记录： <Version> <DateSerial> <Author> <Description>
 * 1.0.0 20180324-01 Rushing0711 M201803240752 新建文件
 ********************************************************************************/
package com.coding.concurrency.example.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.coding.concurrency.annotations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class CountExample1 {

    /**
     * 请求总数
     */
    public static int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    log.info(Thread.currentThread().getName());
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);

    }

    private static void add() {
        count++;
    }
}
