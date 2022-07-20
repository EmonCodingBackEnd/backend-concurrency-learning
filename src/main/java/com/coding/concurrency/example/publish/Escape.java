package com.coding.concurrency.example.publish;

import com.coding.concurrency.annotations.NotRecommend;
import com.coding.concurrency.annotations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private final int thisCanBeEscape = 0;

    public Escape() {
        // 1.构造内部对象
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            // 2.构造完毕之前，就看到了Escape对象的实例
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
