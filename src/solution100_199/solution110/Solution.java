package solution100_199.solution110;

/**
 * Script Created by daidai on 2017/6/8.
 */

import structure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }

    public boolean is(TreeNode root) {
        return (maxLength(root) != -1);
    }

    private int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxLength(root.left);
        if (l == -1) {
            return -1;
        }
        int r = maxLength(root.right);
        if (r == -1) {
            return -1;
        }
        return Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(TreeNode.parse(new Integer[]{1})));
    }
}
