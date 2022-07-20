package com.coding.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean("redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host, @Value("${jedis.port}") int port,
        @Value("${jedis.password}") String password) {
        // 创建连接池配置对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 连接池中最大空闲连接数
        poolConfig.setMaxIdle(10);
        // 连接池中创建的最大连接数
        poolConfig.setMaxTotal(100);
        // 创建连接的超时时间
        poolConfig.setMaxWaitMillis(2000);
        // 表示从连接池中获取连接的时候会先测试一下连接是否可用，这样可以保证取出的连接都是可用的。
        poolConfig.setTestOnBorrow(true);
        // 获取jedis连接池
        return new JedisPool(poolConfig, host, port, 10000, "redis123");
    }
}
