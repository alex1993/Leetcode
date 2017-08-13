package solution100_199.solution148;

/**
 * Script Created by daidai on 2017/8/10.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = prev(head);
        ListNode mid = prev.next;
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                res.next = left;
                left = left.next;
                res.next.next = null;
            } else {
                res.next = right;
                right = right.next;
                res.next.next = null;
            }
            res = res.next;
        }
        if (left != null) {
            res.next = left;
        }
        if (right != null) {
            res.next = right;
        }
        return dummy.next;
    }

    private ListNode prev(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res = solution.sortList(ListNode.parse(new int[]{2, 3, 4, 2, 6, 7, 5, 9}));
        ListNode.print(res);
    }
}
