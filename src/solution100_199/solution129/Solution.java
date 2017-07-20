package solution100_199.solution129;

/**
 * Script Created by daidai on 2017/6/8.
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
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        int sum = 0;
        for (Integer num : res) {
            sum += num;
        }
        return sum;
    }

    private void dfs(TreeNode root, List<Integer> prefix, List<Integer> res) {
        if (root == null) {
            return;
        }

        prefix.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(preToNum(prefix));
        }
        dfs(root.left, prefix, res);
        dfs(root.right, prefix, res);
        prefix.remove(prefix.size() - 1);
    }

    private int preToNum(List<Integer> prefix) {
        int res = 0;
        for (Integer num : prefix) {
            res = (res * 10) + num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(TreeNode.parse(new Integer[]{1, 2, 3, 4})));
    }
}
