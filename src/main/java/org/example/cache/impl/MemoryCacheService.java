package org.example.cache.impl;

import org.example.cache.CacheService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// 内存缓存实现
@Service
public class MemoryCacheService<K, V> implements CacheService<K, V> {
    private final Map<K, V> cache = new ConcurrentHashMap<>();// 使用ConcurrentHashMap实现线程安全

    /**
     * @param key
     * @param value
     * @param ttlSeconds
     */
    @Override
    public void put(K key, V value, long ttlSeconds) {
        put(key,value);
        // 可选：在指定时间后清除缓存项
        if (ttlSeconds > 0) {
            scheduleCacheExpiration(key, ttlSeconds);// 在指定时间后清除缓存项
        }
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
        // 将键值对存入缓存
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.get(key));// 返回Optional对象，避免返回null
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    // 可选：在指定时间后清除缓存项的具体实现
    private void scheduleCacheExpiration(K key, long ttlSeconds) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);// 创建一个单线程调度器
        scheduler.schedule(() -> {// 在指定时间后执行清除缓存项的操作
            cache.remove(key);// 清除缓存项
        }, ttlSeconds, TimeUnit.SECONDS);// 延迟指定时间后执行
    }
}