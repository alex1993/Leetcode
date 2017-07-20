package solution200_299.solution206;

/**
 * Script Created by daidai on 2017/4/16.
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
        ListNode dump = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dump;
            dump = head;
            head = tmp;
        }
        return dump;
    }

    public ListNode reverse(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(ListNode.parse(new int[]{1, 2, 3, 4}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
