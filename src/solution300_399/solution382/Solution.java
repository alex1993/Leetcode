package solution300_399.solution382;

/**
 * Script Created by daidai on 2017/4/16.
 */

import structure.ListNode;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        int count = 1;

        Random random = new Random();
        ListNode next = head.next;
        while (next != null) {
            count++;
            if (random.nextDouble() < 1.0 / count) {
                res = next.val;
            }
            next = next.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(ListNode.parse(new int[]{1, 2, 3}));
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * Codec obj = new Codec(head);
 * int param_1 = obj.getRandom();
 */
