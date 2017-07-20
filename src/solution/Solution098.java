package solution;

import structure.TreeNode;

/**
 * Script Created by daidai on 2017/2/15.
 */
public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode treeNode, long min, long max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= min || treeNode.val >= max) {
            return false;
        }
        return isValid(treeNode.left, min, treeNode.val) && isValid(treeNode.right, treeNode.val, max);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 1, 3};
        TreeNode treeNode = TreeNode.parse(integers);
        Solution098 solution098 = new Solution098();
        System.out.println(solution098.isValidBST(treeNode));
    }

}
