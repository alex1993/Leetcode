package solution200_299.solution206;

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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.reverse(ListNode.parse(new int[]{1, 2, 3, 4}));
        ListNode.print(listNode);
    }
}
