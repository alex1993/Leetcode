package solution100_199.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class LRUCache {

    class DList {
        int key, value;
        DList prev, next;
    }

    int capacity;
    DList head, tail;
    Map<Integer, DList> map;

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
        removeMoveToTail(node);
        return node.value;
    }

    private void removeMoveToTail(DList node) {
        remove(node);
        moveToTail(node);
    }

    private void remove(DList node) {
        DList prev = node.prev;
        DList next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToTail(DList node) {
        DList last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DList node = new DList();
            node.key = key;
            node.value = value;
            moveToTail(node);
            map.put(key, node);
            if (map.size() > capacity) {
                DList deleted = popHead();
                map.remove(deleted.key);
            }
        } else {
            map.get(key).value = value;
            removeMoveToTail(map.get(key));
        }

    }

    private DList popHead() {
        DList node = head.next;
        remove(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
