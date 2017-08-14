package solution100_199.solution109;

/**
 * Script Created by daidai on 2017/8/11.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import structure.ListNode;
import structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        mid.left = toBST(head, slow);
        mid.right = toBST(slow.next, tail);
        return mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(ListNode.parse(new int[]{1, 2, 3, 4, 5, 5, 6}));
        TreeNode.levelPrint(root);
    }
}
