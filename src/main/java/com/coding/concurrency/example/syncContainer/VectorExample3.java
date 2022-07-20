package com.coding.concurrency.example.syncContainer;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.coding.concurrency.annotations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class VectorExample3 {

    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test1(List<Integer> v1) {
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test2(List<Integer> v1) {
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // 正常
    private static void test3(List<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);

        test3(list);
    }
}
