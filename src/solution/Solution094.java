package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/2/22.
 */
public class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                inorder(root.right, result);
            }
        }
    }

    private List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode top = stack.pop();
                result.add(top.val);
                if (top.right != null) {
                    p = top.right;
                }
            }
        }

        return result;
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.parse(new Integer[]{1, 2, 3, 4});
        Solution094 solution094 = new Solution094();
        System.out.println(solution094.inorder(treeNode));
    }
}
