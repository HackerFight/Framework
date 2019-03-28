package com.hacker.framework.cache;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public interface CacheFactory {

    /**
     * 创建缓存
     * @param cacheConfig
     * @param <K>
     * @param <V>
     * @return
     */
    <K, V> CollectionCache<K, V> createCache(CacheConfig<K, V> cacheConfig);
}
