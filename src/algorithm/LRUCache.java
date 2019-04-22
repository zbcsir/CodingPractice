package algorithm;

import java.lang.reflect.Field;
import java.util.*;

// leetcode 146
public class LRUCache {
    private HashMap<Integer, Integer> cache;
    private int capacity;
    private int lastKey;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                boolean remove = false;
                if (this.size() > capacity) {
                    lastKey = eldest.getKey();
                    remove = true;
                }
                return remove;
//                return this.size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        int res = -1;
        if (cache.containsKey(key)) {
            res = cache.get(key);
            cache.remove(key);
            cache.put(key, res);
        }
        return res;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if (cache.size() >= capacity)
                cache.remove(lastKey);
        }
        cache.put(key, value);
    }

    private void printCache(HashMap<Integer, Integer> cache) {
        System.out.println("key size : " + cache.keySet().size());
        Iterator it = cache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.print(entry.getKey() + " : " + entry.getValue() + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.printCache(cache.cache);
        cache.put(2, 2);
        cache.printCache(cache.cache);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.printCache(cache.cache);
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.printCache(cache.cache);
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}
