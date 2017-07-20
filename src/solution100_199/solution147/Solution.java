package solution100_199.solution147;

/**
 * Script Created by daidai on 2017/6/19.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode headBackup = head.next;

            int curVal = head.val;
            ListNode prev = dummy;
            ListNode tmp = dummy.next;
            while (tmp != null && tmp.val <= curVal) {
                tmp = tmp.next;
                prev = prev.next;
            }
            head.next = tmp;
            prev.next = head;

            head = headBackup;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode parse = ListNode.parse(new int[]{5, 2, 6, 3, 7, 1, 4, 8});
        ListNode res = solution.insertionSortList(parse);
        ListNode.print(res);
    }
}
