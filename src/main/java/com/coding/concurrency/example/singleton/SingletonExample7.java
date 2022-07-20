package com.coding.concurrency.example.singleton;

import com.coding.concurrency.annotations.Recommend;
import com.coding.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式：最安全. 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    private SingletonExample7() {}

    public static SingletonExample7 getInstance() {
        return SingleTon.INSTANCE.getSingleton();
    }

    private enum SingleTon {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用了一次
        SingleTon() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
