package solution100_199.solution124;

/**
 * Script Created by daidai on 2017/8/3.
 */

import structure.TreeNode;

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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        maxSum = Math.max(left + right + root.val, maxSum);
        return Math.max(left, right) + root.val;
    }

    //如果想要计算从根节点开始，直到某个节点（不一定是叶子）的最大路径和，那么就是
    //左右子树中较大的那个结果加上当前根节点，当然可能左右子树都不选择
    //递归的分别在左或者右子树中寻找最大路径
    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        return Math.max(left, right) + root.val;
    }

    //计算从根节点到达叶子结点的最大路径长度
    private int maxPathToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathToLeaf(root.left);
        int right = maxPathToLeaf(root.right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxPath(TreeNode.parse(new Integer[]{5, 4, 8, -11, null, 13, 4, 7, 2, null, null, null, 1})));
    }
}
