package com.coding.concurrency.example.immutable;

import com.coding.concurrency.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private static final ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private static final ImmutableSet<Integer> set = ImmutableSet.copyOf(list);

    private static final ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private static final ImmutableMap<Integer, Integer> map2 =
        ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        // list.add(4);
        // set.add(4);
        // map.put(1, 4);
        // map2.put(1, 4);
        log.info("{}", map2.get(5));
    }
}
