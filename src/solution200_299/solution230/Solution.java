package solution200_299.solution230;

/**
 * Script Created by daidai on 2017/8/3.
 */

import structure.TreeNode;

import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                return node.val;
            }
            p = node.right;
        }
        return -1;
    }

    private int solve(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (k <= leftCount) {
            return solve(root.left, k);
        } else if (k > leftCount + 1){
            return solve(root.right, k - leftCount - 1);
        }
        return root.val;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(TreeNode.parse(new Integer[]{3, 1, 4, null, 2}), 3));
    }
}
