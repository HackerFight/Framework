package com.hacker.framework.cache;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by hacker on 2019/3/27 0027.
 */
public class GuavaCacheImpl<K, V> extends AbstractCache<K, V> {

    /**
     * 这里声明成了 protected ，这样子类也可以直接使用，666
     */
    protected final Cache<K, Optional<V>> cache;

    /**
     * 在这个类中的构造器中调用父类的抽象类的构造器
     * @param cache
     * @param cacheConfig
     */
    public GuavaCacheImpl(Cache<K, Optional<V>> cache, CacheConfig cacheConfig){
        super(cacheConfig);
        this.cache = cache;
    }

    @Override
    public V get(K key) {
         Optional<V> ifPresent = cache.getIfPresent(key);
         return (ifPresent != null && ifPresent.isPresent()) ? ifPresent.get() : null;
    }

    @Override
    public boolean put(K key, V value) {
        if (key == null || value == null){
            return false;
        }
        this.cache.put(key, Optional.fromNullable(value));
        return true;
    }

    @Override
    public int size() {
        return (int)this.cache.size();
    }

    @Override
    public boolean isEmpty() {
        return this.cache.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return this.get((K)key)!= null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        if (map != null && !map.isEmpty()){
            Set<? extends Map.Entry<? extends K, ? extends V>> entries = map.entrySet();
            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                 this.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public V remove(Object key) {
        V v = this.get((K) key);
        this.cache.invalidate(key);
        return v;
    }

    @Override
    public void clear() {
        this.cache.invalidateAll();
    }
}
