package com.hacker.framework.cache;

import com.google.common.base.Optional;
import com.google.common.cache.LoadingCache;

/**
 * Created by hacker on 2019/3/28 0028.
 */
public class GuavaLoadingCacheImpl<K, V> extends GuavaCacheImpl<K, V> {

    /**
     * 调用父类的构造器，完成对象的创建
     * @param cache
     * @param cacheConfig
     */
    public GuavaLoadingCacheImpl(LoadingCache<K, Optional<V>> cache, CacheConfig cacheConfig){
        super(cache, cacheConfig);
    }

    @Override
    public V get(K key) {
        Optional<V> unchecked = ((LoadingCache<K, Optional<V>>) cache).getUnchecked(key);
        return (unchecked != null && unchecked.isPresent()) ? unchecked.get() : null;
    }
}
