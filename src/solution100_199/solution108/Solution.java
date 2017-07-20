package solution100_199.solution108;

/**
 * Script Created by daidai on 2017/6/6.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s == e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = helper(nums, s, mid);
        midNode.right = helper(nums, mid + 1, e);
        return midNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        List<Integer> res = new ArrayList<>();
        TreeNode.levelOrder(treeNode, res);
        System.out.println(res);
    }
}
