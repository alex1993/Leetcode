package solution;/*
 * Script Created by daidai on 2017/3/22.
 */

import structure.TreeNode;

public class BSTIterator {

    private TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root.left != null || root.right != null;
    }

    /** @return the next smallest number */
    public int next() {
        if (root.left != null) {
            root = root.left;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        } else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse(new Integer[]{6, 4, 8, null, null, 7, 9});
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * Your solve.BSTIterator will be called like this:
 * solve.BSTIterator i = new solve.BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */