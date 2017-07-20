package solution400_499.solution460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class LFUCache {

    //key value
    private Map<Integer, Integer> values;
    //key count for now
    private Map<Integer, Integer> counts;
    //count and current key list
    private Map<Integer, LinkedHashSet<Integer>> countListMap;
    private int capacity;
    private int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>();
        counts = new HashMap<>();
        countListMap = new HashMap<>();
        countListMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        //key value
        int res = values.get(key);
        //key's count++
        Integer count = counts.get(key);
        counts.put(key, count + 1);

        //count's key list remove cur key
        countListMap.get(count).remove(key);
        //cur count key list is empty, min++
        if (count == min && countListMap.get(count).size() == 0) {
            min++;
        }
        //cur count list size is empty
        if (!countListMap.containsKey(count + 1)) {
            countListMap.put(count + 1, new LinkedHashSet<>());
        }
        countListMap.get(count + 1).add(key);
        return res;
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            //key already exists, update count and key list, may cause countListMap up;
            values.put(key, value);
            get(key);
            return;
        }
        if (values.size() >= capacity) {
            int toDelKey = countListMap.get(min).iterator().next();
            countListMap.get(min).remove(toDelKey);
            values.remove(toDelKey);
        }
        values.put(key, value);
        counts.put(key, 1);
        min = 1;
        countListMap.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
