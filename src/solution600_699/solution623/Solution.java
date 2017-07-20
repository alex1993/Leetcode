package solution600_699.solution623;

/**
 * Script Created by daidai on 2017/6/18.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        dfs(root, 1, v, d);
        return root;
    }

    private void dfs(TreeNode root, int depth, int val, int d) {
        if (root == null) {
            return;
        }
        if (depth == d - 1) {
            TreeNode leftTmp = root.left;
            TreeNode leftNew = new TreeNode(val);
            root.left = leftNew;
            leftNew.left = leftTmp;
            dfs(leftNew, depth + 1, val, d);

            TreeNode rightTmp = root.right;
            TreeNode rightNew = new TreeNode(val);
            root.right = rightNew;
            rightNew.right = rightTmp;
            dfs(rightNew, depth + 1, val, d);
        } else {
            dfs(root.left, depth + 1, val, d);
            dfs(root.right, depth + 1, val, d);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.addOneRow(TreeNode.parse(new Integer[]{4,}), 1, 2);
        List<Integer> res = new ArrayList<>();
        TreeNode.preOrder(treeNode, res);
        System.out.println(res);
    }
}
