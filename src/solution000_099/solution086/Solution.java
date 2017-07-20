package solution000_099.solution086;

import structure.ListNode;

/**
 * Script Created by daidai on 2017/6/3.
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }

            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.parse(new int[]{1, 4, 3, 2, 5, 2});
        solution.partition(listNode, 3);
        ListNode.print(listNode);
    }
}