package com.coding.concurrency.example.syncContainer;

import java.util.List;
import java.util.Vector;

import com.coding.concurrency.annotations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static final List<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            Thread thread1 =
                    new Thread() {
                        @Override
                        public void run() {
                            for (int i = 0; i < list.size(); i++) {
                                list.remove(i);
                            }
                        }
                    };
            Thread thread2 =
                    new Thread() {
                        @Override
                        public void run() {
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i);
                            }
                        }
                    };

            thread1.start();
            thread2.start();
        }
    }
}
