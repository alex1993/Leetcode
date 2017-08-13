package solution100_199.solution138;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/8.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = head;
        while (dummy != null) {
            map.put(dummy, new RandomListNode(dummy.label));
            dummy = dummy.next;
        }

        dummy = head;
        while (dummy != null) {
            map.get(dummy).next = map.get(dummy.next);
            map.get(dummy).random = map.get(dummy.random);
            dummy = dummy.next;
        }
        return map.get(head);
    }
}