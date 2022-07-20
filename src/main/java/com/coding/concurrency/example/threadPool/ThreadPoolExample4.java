package com.coding.concurrency.example.threadPool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        /*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        // 延迟3秒执行
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        }, 3, TimeUnit.SECONDS);*/
        // executorService.shutdown();

        // 以指定的速率执行任务
        /*executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        }, 1, 3, TimeUnit.SECONDS);*/

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }
}
