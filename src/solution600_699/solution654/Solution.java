package solution600_699.solution654;

/**
 * Script Created by daidai on 2017/8/6.
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return divideConquer(nums, 0, nums.length - 1);
    }

    private TreeNode divideConquer(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int index = maxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = divideConquer(nums, start, index - 1);
        root.right = divideConquer(nums, index + 1, end);
        return root;
    }

    private int maxIndex(int[] nums, int start, int end) {
        int max = nums[start];
        int res = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode node = solution.constructMaximumBinaryTree(nums);
        TreeNode.levelPrint(node);
    }
}