package solution;

import structure.TreeNode;

/**
 * Script Created by daidai on 2017/3/22.
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low = Math.min(p.val, q.val);
        int high = Math.max(p.val, q.val);
        return find(root, low, high);
    }

    private TreeNode find(TreeNode root, int low, int high) {
        if (root.val >= low && root.val <= high) {
            return root;
        } else if (root.val > high) {
            return find(root.left, low, high);
        } else {
            return find(root.right, low, high);
        }
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {
        Solution235 solution235 = new Solution235();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;
//        structure.TreeNode root = structure.TreeNode.parse(new Integer[]{2, 1});
        System.out.println(solution235.find(node1, node1, node2).val);
    }

}
