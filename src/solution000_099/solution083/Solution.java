package solution000_099.solution083;

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

    private ListNode deleteDuplicates(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        node.next = deleteDuplicates(node.next);
        return node.val == node.next.val ? node.next : node;
    }

    public ListNode delete(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode tmp = node;
        while (tmp.next != null) {
            if (tmp.next.val == tmp.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.parse(new int[]{1, 1, 1});
        Solution solution = new Solution();
        ListNode res = solution.delete(listNode);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
