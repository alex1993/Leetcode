package solution100_199.solution124;

/**
 * Script Created by daidai on 2017/6/8.
 */

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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        maxSum = Math.max(left + right + root.val, maxSum);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(TreeNode.parse(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
    }

}
