package solution000_099.solution002;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            res.next = new ListNode(val);
            res = res.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(ListNode.parse(new int[]{5}), ListNode.parse(new int[]{5}));
        ListNode.print(node);
    }
}
