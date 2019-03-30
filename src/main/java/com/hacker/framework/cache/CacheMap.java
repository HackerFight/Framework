package com.hacker.framework.cache;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.hacker.framework.cache.enums.CacheTypeEnum;
import com.hacker.framework.cache.enums.ExpireTypeEnum;
import com.hacker.framework.cache.loader.DataLoader;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/**
 *  实现带有 范型的接口时，一定在实现类上也要指定！ 否则报错！！！
 * @param <K>
 * @param <V>
 * Created by hacker on 2019/3/27 0027.
 */
public class CacheMap<K, V> implements Map<K, V>{

    private static final Set<String> CACHE_NAME = Sets.newConcurrentHashSet();
    //为何要这样定义？
    protected static final CacheFactory CACHE_FACTORY = new CacheFactoryImpl();

    private CollectionCache<K, V> zdfCache;
    private CacheConfig<K, V> cacheConfig;

    /**
     * 创建对象
     * @param cacheConfig
     */
    public CacheMap(CacheConfig<K, V> cacheConfig){
        Preconditions.checkNotNull(cacheConfig.getCacheName(), "cache name can not null");
        Preconditions.checkState(!CACHE_NAME.contains(cacheConfig.getCacheName()), "cache name: "
                + cacheConfig.getCacheName() + "has already exist");
        Preconditions.checkState(!StringUtils.isEmpty(cacheConfig.getCacheName()), "cache name can not null");
        this.cacheConfig = cacheConfig;
        this.zdfCache = CACHE_FACTORY.createCache(cacheConfig);
        CACHE_NAME.add(cacheConfig.getCacheName());
    }

    public CacheMap(String cacheName){
        this(cacheName, ExpireTypeEnum.EXPIRE_AFTER_WRITE, null);
    }

    public CacheMap(String cacheName, long cacheExpire){
        this(cacheName, cacheExpire, ExpireTypeEnum.EXPIRE_AFTER_WRITE, null);
    }

    public CacheMap(String cacheName, ExpireTypeEnum expireTypeEnum, DataLoader dataLoader){
        //这个 DEFAULT_EXPIRE_TIME 也是定义成了 public 类型
        this(cacheName, CacheConfig.DEFAULT_EXPIRE_TIME, expireTypeEnum, dataLoader);
    }

    public CacheMap(String cacheName, long cacheExpire, ExpireTypeEnum expireTypeEnum, DataLoader dataLoader){
        //DEFAULT_MAX_SIZE 在类中定义成了 public 类型
        this(new CacheConfig<K, V>(cacheName, cacheExpire, expireTypeEnum, CacheTypeEnum.LOCAL,
                CacheConfig.DEFAULT_MAX_SIZE, dataLoader));
    }

    public int size() {
        return this.zdfCache.size();
    }

    public boolean isEmpty() {
        return this.zdfCache.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.zdfCache.containsKey(key);
    }

    public boolean containsValue(Object value) {
        throw new RuntimeException("暂不支持此方法");
    }

    public V get(Object key) {
        return this.zdfCache.get((K)key);
    }

    public V put(K key, V value) {
        if(this.zdfCache.put(key, value)){
            return value;
        }
        return null;
    }

    public V remove(Object key) {
        return this.zdfCache.remove(key);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        this.zdfCache.putAll(m);
    }

    public void clear() {
        this.zdfCache.clear();
    }

    public Set<K> keySet() {
        throw new RuntimeException("暂不支持此方法");
   }

    public Collection<V> values() {
        throw new RuntimeException("暂不支持此方法");
    }

    public Set<Entry<K, V>> entrySet() {
        throw new RuntimeException("暂不支持此方法");
    }
}
