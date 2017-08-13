package solution500_599.solution513;

/**
 * Script Created by daidai on 2017/8/3.
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
    private int depth;
    private int leftMost;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return leftMost;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > depth) {
            leftMost = root.val;
            depth = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findBottomLeftValue(TreeNode.parse(new Integer[]{2, 1, 3})));
        System.out.println(solution.findBottomLeftValue(TreeNode.parse(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7})));
    }
}
