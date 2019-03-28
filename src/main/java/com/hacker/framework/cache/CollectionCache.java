package com.hacker.framework.cache;

import java.util.Map;

/**
 * Created by hacker on 2019/3/27 0027.
 *
 */
public interface CollectionCache<K, V> {

    /**
     * 通过key 获取 value
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 放入key-value
     * @param key
     * @param value
     * @return
     */
    boolean put(K key, V value);

    /**
     * 缓存数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 包含某一个key
     * @param key， 参数是 Object 类型
     * @return
     */
    boolean containsKey(Object key);

    /**
     * 放入多个
     * @param map
     */
    void putAll(Map<? extends K, ? extends V> map);

    /**
     * 移除某一个key，并返回该key的 value
   @param key
     * @return
     */
    V remove(Object key);

    /**
     * 清空缓存
     */
    void clear();

    /**
     * 获取缓存配置类
     * @return
     */
    CacheConfig getCacheConfig();
}
