package solution600_699.solution617;

/**
 * Script Created by daidai on 2017/6/11.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        } else if (t1 == null) {
            TreeNode root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
            return root;
        } else {
            TreeNode root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
            return root;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.mergeTrees(TreeNode.parse(new Integer[]{1, 2, null, 3}), TreeNode.parse(new Integer[]{1, null, 2, null, 3}));
        List<Integer> res = new ArrayList<>();
        TreeNode.levelOrder(treeNode, res);
        System.out.println(res);
    }
}
