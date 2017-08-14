package solution600_699.solution617;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    private TreeNode solve(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode merge = new TreeNode(t1.val + t2.val);
            merge.left = solve(t1.left, t2.left);
            merge.right = solve(t1.right, t2.right);
            return merge;
        } else if (t1 == null && t2 != null) {
            TreeNode merge = new TreeNode(t2.val);
            merge.left = solve(null, t2.left);
            merge.right = solve(null, t2.right);
            return merge;
        } else if (t1 != null) {
            TreeNode merge = new TreeNode(t1.val);
            merge.left = solve(t1.left, null);
            merge.right = solve(t1.right, null);
            return merge;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode res = solution.solve(TreeNode.parse(new Integer[]{1, 3, 2, 5}), TreeNode.parse(new Integer[]{2, 1, 3, null, 4, null, 7}));
        TreeNode.levelPrint(res);
    }
}
