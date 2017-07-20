package solution000_099.solution082;

/**
 * Script Created by daidai on 2017/6/4.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(0);
        ListNode tmp = dump;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            } else {
                tmp.next = head;
                tmp = tmp.next;
            }
            head = head.next;

        }

        tmp.next = null;
        return dump.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(ListNode.parse(new int[]{1, 1}));
        ListNode.print(listNode);
    }
}
