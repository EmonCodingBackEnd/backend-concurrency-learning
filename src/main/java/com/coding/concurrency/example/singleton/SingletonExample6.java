package com.coding.concurrency.example.singleton;

import com.coding.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式. 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有构造函数
    private SingletonExample6() {}

    // 单例对象 必须在静态块之前
    private static final SingletonExample6 instance;

    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
