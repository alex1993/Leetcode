package solution000_099.solution098;

/**
 * Script Created by daidai on 2017/8/2.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public boolean isValidBST(TreeNode root) {
        return midOrder(root, new ArrayList<>());
    }

    private boolean midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return true;
        }
        boolean left = midOrder(root.left, res);
        if (!res.isEmpty() && root.val <= res.get(res.size() - 1)) {
            return false;
        }
        res.add(root.val);
        boolean right = midOrder(root.right, res);
        return left && right;
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(TreeNode.parse(new Integer[]{1, 1})));
    }
}
