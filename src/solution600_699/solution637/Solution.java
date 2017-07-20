package solution600_699.solution637;

/**
 * Script Created by daidai on 2017/7/9.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Double> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(avg(tmp));
        }
        return res;
    }

    private Double avg(List<TreeNode> nodes) {
        Double res = 0.0;
        for (TreeNode node : nodes) {
            res += node.val;
        }
        return res / nodes.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageOfLevels(TreeNode.parse(new Integer[]{1})));
    }
}
