package solution100_199.solution105;

import structure.TreeNode;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int preIndex, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preIndex >= preOrder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preIndex]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preIndex]) {
                inIndex = i;
                break;
            }
        }
        root.left = build(preIndex + 1, inStart, inIndex - 1, preOrder, inOrder);
        root.right = build(inIndex - inStart + 1 + preIndex, inIndex + 1, inEnd, preOrder, inOrder);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{5, 3, 6, 9, 8, 2, 11}, new int[]{6, 3, 9, 8, 5, 11, 2});
        TreeNode.levelPrint(node);
    }
}
