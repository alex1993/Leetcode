package solution600_699.solution606;

/**
 * Script Created by daidai on 2017/6/4.
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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrder(t, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append('(');
            preOrder(root.left, sb);
            sb.append(')');
        } else if (root.right != null) {
            sb.append("()");
        }
        if (root.right != null) {
            sb.append('(');
            preOrder(root.right, sb);
            sb.append(')');
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tree2str(TreeNode.parse(new Integer[]{1})));
    }
}
