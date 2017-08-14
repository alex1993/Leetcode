package solution100_199.solution108;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, s, mid - 1);
        root.right = helper(nums, mid + 1, e);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.levelPrint(root);
    }
}