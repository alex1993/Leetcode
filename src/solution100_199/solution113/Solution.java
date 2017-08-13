package solution100_199.solution113;

/**
 * Script Created by daidai on 2017/8/3.
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
        dfs(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> prefix, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        prefix.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(prefix));
            //需要记得删除最后一个元素，否则就直接写成 if else 的形式，要不不会调用最后一行的prefix.remove()!!!
            prefix.remove(prefix.size() - 1);
            return;
        }
        dfs(res, prefix, root.left, sum - root.val);
        dfs(res, prefix, root.right, sum - root.val);
        prefix.remove(prefix.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.pathSum(TreeNode.parse(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(res);
    }
}
