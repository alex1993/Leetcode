package solution100_199.solution173;

/**
 * Script Created by daidai on 2017/6/22.
 */

import structure.TreeNode;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode root = stack.pop();
        int res = root.val;
        if (root.right != null) {
            root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(TreeNode.parse(new Integer[]{7, 5, 13, 4, 6, 8, 15, null,}));
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
