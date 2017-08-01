package solution600_699.solution652;

/**
 * Script Created by daidai on 2017/7/30.
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(findFirstValid(root), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    private TreeNode findFirstValid(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left != null && treeNode.right != null) {
            return treeNode;
        }
        if (treeNode.left != null) {
            return findFirstValid(treeNode.left);
        } else {
            return findFirstValid(treeNode.right);
        }
    }

    private void dfs(TreeNode root, Set<String> first, Set<String> second, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        String path = hash(root);
        if (!first.contains(path)) {
            first.add(path);
        } else {
            if (!second.contains(path)) {
                second.add(path);
                res.add(root);
            }
        }
        dfs(root.left, first, second, res);
        dfs(root.right, first, second, res);
    }

    private String hash(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + hash(root.left) + hash(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(TreeNode.parse(new Integer[]{}));
        for (TreeNode treeNode : duplicateSubtrees) {
            TreeNode.levelPrint(treeNode);
        }
    }

}
