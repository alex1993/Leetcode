package solution200_299.solution222;

import structure.TreeNode;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0) {
            return 0;
        } else {
            if (height(root.right) == h - 1) {
                return (1 << h) + countNodes(root.right);
            } else {
                return (1 << h - 1) + countNodes(root.left);
            }
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + height(root.left);
        }
    }

    private int count(TreeNode root) {
        int h = height(root);
        int nodes = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += (1 << h);
                root = root.right;
            } else {
                nodes += (1 << h - 1);
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.count(TreeNode.parse(new Integer[]{1})));
    }


}
