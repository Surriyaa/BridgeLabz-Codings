package com.queue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (cache.size() >= capacity) {
            int leastUsedKey = cache.entrySet().iterator().next().getKey();
            cache.remove(leastUsedKey);
        }
        cache.put(key, value);
    }
    public static void main(String[] args) {
    	System.out.println("Testing LRU Cache:");
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println("LRU Cache get(1): " + lruCache.get(1));  // Should print 1
        lruCache.put(3, 3);  // Evicts key 2
        System.out.println("LRU Cache get(2): " + lruCache.get(2));  // Should print -1
        lruCache.put(4, 4);  // Evicts key 1
        System.out.println("LRU Cache get(1): " + lruCache.get(1));  // Should print -1
        System.out.println("LRU Cache get(3): " + lruCache.get(3));  // Should print 3
        System.out.println("LRU Cache get(4): " + lruCache.get(4));  // Should print 4
        System.out.println();
	}
}
