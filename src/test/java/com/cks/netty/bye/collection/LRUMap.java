package com.cks.netty.bye.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: cks
 * @Date: Created by 2019/7/5 9:37
 * @Package: com.cks.netty.bye.collection
 * @Description:
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {

    private int _maxSize;

    /**
     * accessOrder   false： 基于插入顺序     true：  基于访问顺序
     *
     * @param maxSize
     */
    public LRUMap(int maxSize) {
        super(maxSize + 1, 1.0f, true);
        this._maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this._maxSize;
    }
}
