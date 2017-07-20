package solution100_199.solution109;

/**
 * Script Created by daidai on 2017/6/6.
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

import java.util.ArrayList;
import java.util.List;

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
        TreeNode treeNode = solution.sortedListToBST(ListNode.parse(new int[]{-1, 0, 1, 2}));
        List<Integer> res = new ArrayList<>();
        TreeNode.levelOrder(treeNode, res);
        System.out.println(res);
    }
}
