package com.cn.zy.nio.com.cn.zy.channel.test_abidc;

import javafx.beans.binding.ObjectExpression;
import org.junit.Test;

import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhangyi
 * @date: 2018/11/27 21:10
 * @description:
 */
public class HashMapAndConcurrentHashMap {

    @Test
    public void hashMap(){
        Map<Object,Object> map = new MyHashMap();
        map.put(1,0);
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println(key+"--"+value);
        }
    }
}
class MyHashMap<K,V> implements Map<K,V>{

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
