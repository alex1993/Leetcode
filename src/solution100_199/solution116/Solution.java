package solution100_199.solution116;

/**
 * Script Created by daidai on 2017/8/2.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        helper(root.left, root.right);
    }

    private void helper(TreeLinkNode left, TreeLinkNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}
