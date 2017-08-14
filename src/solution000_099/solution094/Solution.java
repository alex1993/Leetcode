package solution000_099.solution094;

/**
 * Script Created by daidai on 2017/8/2.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);

            root = node.right;

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(TreeNode.parse(new Integer[]{1, null, 2, 3}));
        System.out.println(list);
    }
}
