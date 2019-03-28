package com.hacker.framework.cache;
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

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(Object key) {
        return null;
    }

    public V put(K key, V value) {
        return null;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
