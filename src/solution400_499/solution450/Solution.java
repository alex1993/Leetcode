package solution400_499.solution450;

/**
 * Script Created by daidai on 2017/8/8.
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
    //递归的删除key节点
    //如果发现要删除的节点更大，那么去右子树删除，并且把右子树的删除结果赋值给 根 的右子树
    //同理节点更小的情况，如果发现就是要删除的节点了，判断该节点是否有左或者右子树
    //如果一边没有则返回另一边
    //如果有两个孩子，则把左子树的最右节点（最大值）赋值给当前节点，并且递归地删除左子树的该节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    private TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.deleteNode(TreeNode.parse(new Integer[]{5, 3, 10, null, 4, 7, 11}), 7);
        TreeNode.levelPrint(node);
        TreeNode node2 = solution.deleteNode(TreeNode.parse(new Integer[]{5, 3, 10, null, 4, 7, 11}), 12);
        TreeNode.levelPrint(node2);

    }
}
