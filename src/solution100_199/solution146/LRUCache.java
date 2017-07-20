package solution100_199.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class LRUCache {
    class DList {
        int key, value;
        DList prev, next;

    }

    private Map<Integer, DList> map;
    private int capacity;
    private DList head;
    private DList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DList();
        tail = new DList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DList node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DList node = new DList();
            node.key = key;
            node.value = value;
            addTail(node);
            map.put(key, node);
            if (map.size() > capacity) {
                DList deleted = popHead();
                map.remove(deleted.key);
            }
        } else {
            map.get(key).value = value;
            moveToTail(map.get(key));
        }
    }

    public void addTail(DList node) {
        tail.prev.next = node;
        node.prev = tail.prev;

        tail.prev = node;
        node.next = tail;
    }

    public void removeNode(DList node) {
        DList prev = node.prev;
        DList next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToTail(DList node) {
        removeNode(node);
        addTail(node);
    }

    public DList popHead() {
        DList toDelete = head.next;
        removeNode(toDelete);
        return toDelete;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);    // evicts key 2
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
