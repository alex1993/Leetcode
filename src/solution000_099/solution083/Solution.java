package solution000_099.solution083;

/**
 * Script Created by daidai on 2017/8/11.
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head;
            }
            prev = prev.next;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode delete(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = delete(head.next);
        return node.val == node.next.val ? node.next : node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = solution.deleteDuplicates(ListNode.parse(new int[]{}));
        ListNode.print(node);
    }
}
