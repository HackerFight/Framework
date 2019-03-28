package com.hacker.framework.cache;

import com.google.common.base.Optional;
import com.google.common.cache.*;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class CacheFactoryImpl implements CacheFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheFactoryImpl.class);

    private static ListeningExecutorService executorService;

    static {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("cache-refresh-%d").build();
        executorService = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(), threadFactory));
    }


    /**
     * 创建缓存
     * @param cacheConfig
     * @param <K>
     * @param <V>
     * @return
     */
    @Override
    public <K, V> CollectionCache<K, V> createCache(CacheConfig<K, V> cacheConfig) {

        if (cacheConfig == null){
            return null;
        }

        switch (cacheConfig.getCacheType()) {
            case LOCAL:
                Cache<K, Optional<V>> cache;
                switch (cacheConfig.getExpireType()){
                    case EXPIRE_AFTER_WRITE_AUTO_LOAD:
                        cache = CacheBuilder.newBuilder()
                                .maximumSize(cacheConfig.getCacheMaxSize())
                                .expireAfterWrite(cacheConfig.getCacheExpire(), TimeUnit.MILLISECONDS)
                                //注意：这里不要使用范型，不然报错，应该使用Object
                                .removalListener(new RemovalListener<Object, Object>() {
                                    @Override
                                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                                        LOGGER.info("CacheName: " + cacheConfig.getCacheName() + "has been removed;"
                                                + notification.getCause() );
                                    }
                                }).build(new CacheLoader<K, Optional<V>>() {
                                    @Override
                                    public Optional<V> load(K key) throws Exception {
                                        //这里很厉害了
                                        V load = cacheConfig.getDataLoader().load(key);
                                        return Optional.fromNullable(load);
                                    }
                                });
                        return new GuavaLoadingCacheImpl<K, V>((LoadingCache) cache, cacheConfig);
                    case REFRESH_AFTER_WRITE_AUTO_LOAD:
                        break;

                    case EXPIRE_AFTER_WRITE:
                        break;
                }
            case TAIR:
                break;
            default:
                break;
        }

        return null;
    }
}















