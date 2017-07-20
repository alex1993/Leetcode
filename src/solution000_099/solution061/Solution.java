package solution000_099.solution061;

/**
 * Script Created by daidai on 2017/5/28.
 */

import structure.ListNode;

import java.text.ParseException;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int count = count(head);
        if (count == 0) {
            return head;
        }
        k %= count;
        if (k == 0) {
            return head;
        }
        ListNode tail = tail(head);

        ListNode dump = head;
        ListNode prev = null;
        for (int i = 0; i < count - k; i++) {
            prev = dump;
            dump = dump.next;
        }
        if (prev != null) {
            prev.next = null;
            tail.next = head;
            return dump;
        } else {
            return head;
        }
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode dump = head;
        while (dump != null) {
            count++;
            dump = dump.next;
        }
        return count;
    }

    private ListNode tail(ListNode head) {
        ListNode dump = head;
        while (dump.next != null) {
            dump = dump.next;
        }
        return dump;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(ListNode.parse(new int[]{1}), 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
