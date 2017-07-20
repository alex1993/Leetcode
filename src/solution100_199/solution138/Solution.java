package solution100_199.solution138;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/4/16.
 */

// Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dump = head;
        while (dump != null) {
            map.put(dump, new RandomListNode(dump.label));
            dump = dump.next;
        }

        dump = head;
        while (dump != null) {
            map.get(dump).next = map.get(dump.next);
            map.get(dump).random = map.get(dump.random);
            dump = dump.next;
        }
        return map.get(head);
    }

}
