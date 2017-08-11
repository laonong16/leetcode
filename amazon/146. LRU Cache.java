/*
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


*/

public class LRUCache {
    private int capacity;
    Map<Integer, CacheNode> map;
    CacheNode head;
    CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new CacheNode(-1,-1);
        tail = new CacheNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            CacheNode node = map.get(key);
            int value = node.val;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToTail(node);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(get(key)!= -1) {
            map.get(key).val = value;
            return;
        } else {
            if(map.size() == capacity) {
                map.remove(head.next.val);
                head.next = head.next.next;
                head.next.prev  = head;
            } 
            CacheNode  node = new CacheNode(key,value);
            map.put(key,node);
            moveToTail(node);
        }
    }
    public void  moveToTail(CacheNode node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }
   
    public class CacheNode {
        int key;
        int val;
        CacheNode prev;
        CacheNode next;
        public CacheNode(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }


}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */