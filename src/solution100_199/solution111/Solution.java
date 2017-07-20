package solution100_199.solution111;

/**
 * Script Created by daidai on 2017/6/16.
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 1);
    }

    private int helper(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return level;
        }

        int lDepth = Integer.MAX_VALUE;
        if (node.left != null) {
            lDepth = helper(node.left, level + 1);
        }

        int rDepth = Integer.MAX_VALUE;
        if (node.right != null) {
            rDepth = helper(node.right, level + 1);
        }

        return Math.min(lDepth, rDepth);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeNode.parse(new Integer[]{1, 2, 3, 4, null, 5, null, 6, 7})));
    }
}
