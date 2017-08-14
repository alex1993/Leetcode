package solution000_099.solution023;

/**
 * Script Created by daidai on 2017/8/5.
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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            } else {
                continue;
            }
            lists[i] = lists[i].next;
        }

        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }
            node.next = null;
            res.next = node;
            res = res.next;
        }
        return dummy.next;
    }

    public ListNode solve(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideConquer(lists, 0, lists.length - 1);
    }

    public ListNode divideConquer(ListNode[] lists, int start, int end) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ListNode.parse(new int[]{1, 5, 6, 7, 9});
        ListNode listNode2 = ListNode.parse(new int[]{2, 3, 4, 10, 19});
        ListNode res = solution.solve(new ListNode[]{listNode1, listNode2});
        ListNode.print(res);
    }
}
