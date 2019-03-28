package com.hacker.framework.cache;

/**
 * Created by Administrator on 2019/3/27 0027.
 */
public abstract class AbstractCache<K, V> implements CollectionCache<K, V> {

    private CacheConfig<K, V> cacheConfig;

    /**
     * 抽象类也定义了一个 构造器，厉害了，还是第一次遇到了
     * @param cacheConfig
     */
    public AbstractCache(CacheConfig cacheConfig){
        this.cacheConfig = cacheConfig;
    }

    @Override
    public CacheConfig getCacheConfig() {
        return cacheConfig;
    }
}
