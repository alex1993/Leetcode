package solution400_499.solution437;

/**
 * Script Created by daidai on 2017/8/14.
 */

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left , sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }

    public int solve(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }

    private int findPathSum(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        sum += root.val;
        int numToCur = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int res = numToCur + findPathSum(root.left, sum, target, map) + findPathSum(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pathSum(TreeNode.parse(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
    }
}
