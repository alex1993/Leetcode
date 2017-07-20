package solution000_099.solution023;

/**
 * Script Created by daidai on 2017/7/20.
 */

import structure.ListNode;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = divideConquer(lists, start, mid);
        ListNode right = divideConquer(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (left != null && right != null) {
            int cur;
            if (left.val < right.val) {
                cur = left.val;
                left = left.next;
            } else {
                cur = right.val;
                right = right.next;
            }
            ListNode next = new ListNode(cur);
            res.next = next;
            res = next;
        }

        if (left != null) {
            res.next = left;
        }
        if (right != null) {
            res.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ListNode.parse(new int[]{1, 5, 6, 7, 9});
        ListNode listNode2 = ListNode.parse(new int[]{2, 3, 4, 10, 19});
        ListNode res = solution.mergeKLists(new ListNode[]{listNode1, listNode2});
        ListNode.print(res);
    }
}
