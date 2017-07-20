package solution100_199.solution101;

/**
 * Script Created by daidai on 2017/6/6.
 */

import structure.TreeNode;

import java.util.*;

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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(TreeNode.parse(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(solution.isSymmetric(TreeNode.parse(new Integer[]{1, 2, 2, null, 3, null, 3})));
        System.out.println(solution.isSymmetric(TreeNode.parse(new Integer[]{1})));
        System.out.println(solution.isSymmetric(TreeNode.parse(new Integer[]{1, 2, 3, 3, null, 2, null})));
    }
}
