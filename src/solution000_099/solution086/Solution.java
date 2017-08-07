package solution000_099.solution086;

/**
 * Script Created by daidai on 2017/8/1.
 */

import structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode smallerDummy = smaller;
        ListNode bigger = new ListNode(0);
        ListNode biggerDummy = bigger;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        bigger.next = null;
        smaller.next = biggerDummy.next;
        return smallerDummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode partition = solution.partition(ListNode.parse(new int[]{2, 1}), 1);
        ListNode.print(partition);
    }
}
