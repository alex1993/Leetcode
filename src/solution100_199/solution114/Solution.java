package solution100_199.solution114;

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
    private TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = TreeNode.parse(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(tree);
        TreeNode.levelPrint(tree);
    }
}
