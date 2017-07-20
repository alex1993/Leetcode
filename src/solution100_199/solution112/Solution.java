package solution100_199.solution112;

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
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(TreeNode.parse(new Integer[]{}), 0));
    }
}
