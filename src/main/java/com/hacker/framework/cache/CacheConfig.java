package com.hacker.framework.cache;

import com.hacker.framework.cache.enums.CacheTypeEnum;
import com.hacker.framework.cache.enums.ExpireTypeEnum;
import com.hacker.framework.cache.loader.DataLoader;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public class CacheConfig<K, V> {

    //默认最大值
    public static final int DEFAULT_MAX_SIZE = 10000;
    //默认缓存失效时间（60s)
    public static final int DEFAULT_EXPIRE_TIME = 60; //s

    //缓存名称
    private String cacheName;

    //缓存失效时间
    private long cacheExpire;

    //缓存key-value的最大个数
    private int cacheMaxSize = DEFAULT_MAX_SIZE;

    //超时类型
    private ExpireTypeEnum expireType = ExpireTypeEnum.EXPIRE_AFTER_WRITE;

    //缓存类型,默认是本地缓存
    private CacheTypeEnum cacheType = CacheTypeEnum.LOCAL;

    //数据加载器
    private DataLoader<K, V> dataLoader;

    public CacheConfig(){}

    public CacheConfig(String cacheName, long cacheExpire, ExpireTypeEnum expireType,
                       CacheTypeEnum cacheType, int cacheMaxSize, DataLoader<K,V> dataLoader){
        this.cacheName = cacheName;
        this.cacheExpire = cacheExpire;
        this.expireType = expireType;
        this.cacheType = cacheType;
        this.cacheMaxSize = cacheMaxSize;
        this.dataLoader = dataLoader;
    }

    public CacheConfig(String cacheName, long cacheExpire, ExpireTypeEnum expireType, DataLoader<K, V> dataLoader){
        this.cacheName = cacheName;
        this.cacheExpire = cacheExpire;
        this.expireType = expireType;
        this.dataLoader = dataLoader;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return cacheName;
    }

    public long getCacheExpire() {
        return cacheExpire;
    }

    public void setCacheExpire(long cacheExpire) {
        this.cacheExpire = cacheExpire;
    }

    public int getCacheMaxSize() {
        return cacheMaxSize;
    }

    public void setCacheMaxSize(int cacheMaxSize) {
        this.cacheMaxSize = cacheMaxSize;
    }

    public ExpireTypeEnum getExpireType() {
        return expireType;
    }

    public void setExpireType(ExpireTypeEnum expireType) {
        this.expireType = expireType;
    }

    public CacheTypeEnum getCacheType() {
        return cacheType;
    }

    public void setCacheType(CacheTypeEnum cacheType) {
        this.cacheType = cacheType;
    }

    public DataLoader<K, V> getDataLoader() {
        return dataLoader;
    }

    public void setDataLoader(DataLoader<K, V> dataLoader) {
        this.dataLoader = dataLoader;
    }
}
