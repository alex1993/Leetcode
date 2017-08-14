package solution500_599.solution572;

/**
 * Script Created by daidai on 2017/8/14.
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubtree(TreeNode.parse(new Integer[]{3, 4, 5, 1, 2}), TreeNode.parse(new Integer[]{4, 1, 2})));
        System.out.println(solution.isSubtree(TreeNode.parse(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0}), TreeNode.parse(new Integer[]{4, 1, 2})));
    }
}
