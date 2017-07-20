package solution100_199.solution104;

/**
 * Script Created by daidai on 2017/6/19.
 */

import structure.TreeNode;

import java.util.Stack;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> height = new Stack<>();
        stack.push(root);
        height.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            Integer first = height.pop();
            max = Math.max(first, max);
            if (top.left != null) {
                stack.push(top.left);
                height.push(first + 1);
            }
            if (top.right != null) {
                stack.push(top.right);
                height.push(first + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(TreeNode.parse(new Integer[]{1, 2, 3, 4, 5, 6})));
    }
}
