package solution400_499.solution404;

/**
 * Script Created by daidai on 2017/7/31.
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        return left + right + res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(TreeNode.parse(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
