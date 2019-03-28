package com.hacker.framework.cache.loader;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public interface DataLoader<K, V> {

    /**
     *  数据加载回调接口
     * @param key
     * @return
     */
    V load(K key);
}
