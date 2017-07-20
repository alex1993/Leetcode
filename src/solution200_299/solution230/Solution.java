package solution200_299.solution230;

/**
 * Script Created by daidai on 2017/6/24.
 */

import structure.TreeNode;

import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                //visit left first
                stack.push(root);
                root = root.left;
            } else {
                //visit root secondly
                TreeNode node = stack.pop();
                i++;
                if (i == k) {
                    return node.val;
                }

                //visit right lastly
                root = node.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(TreeNode.parse(new Integer[]{3, 1, 4, null, 2}), 3));
    }
}
