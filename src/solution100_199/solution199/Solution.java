package solution100_199.solution199;

/**
 * Script Created by daidai on 2017/6/8.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, res, level + 1);
        }
        if (root.left != null) {
            dfs(root.left, res, level + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rightSideView(TreeNode.parse(new Integer[]{})));
    }
}
