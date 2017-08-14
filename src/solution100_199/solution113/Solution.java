package solution100_199.solution113;

/**
 * Script Created by daidai on 2017/8/14.
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        sum(root, res, new ArrayList<>(), sum);
        return res;
    }

    private void sum(TreeNode root, List<List<Integer>> res, List<Integer> prefix, int target) {
        if (root == null) {
            return;
        }
        prefix.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(prefix));
        } else {
            sum(root.left, res, prefix, target - root.val);
            sum(root.right, res, prefix, target - root.val);
        }
        prefix.remove(prefix.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.pathSum(TreeNode.parse(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(res);
    }
}
