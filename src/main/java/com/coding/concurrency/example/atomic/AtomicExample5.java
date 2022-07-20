package com.coding.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import com.coding.concurrency.annotations.ThreadSafe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    // 必须volatile修饰，且非static修饰
    @Getter public volatile int count = 100;

    private static final AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 1, {}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 2, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
