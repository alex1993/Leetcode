package solution100_199.solution106;

import structure.TreeNode;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return build(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode build(int postIndex, int inStart, int inEnd, int[] inOrder, int[] postOrder) {
        if (postIndex < 0 || postIndex >= postOrder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postIndex]);
        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == postOrder[postIndex]) {
                inIndex = i;
                break;
            }
        }
        root.left = build(postIndex - (inEnd - inIndex) - 1, inStart, inIndex - 1, inOrder, postOrder);
        root.right = build(postIndex - 1, inIndex + 1, inEnd, inOrder, postOrder);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(new int[]{6, 3, 9, 8, 5, 11, 2}, new int[]{6, 8, 9, 3, 11, 2, 5});
        TreeNode.levelPrint(node);
    }
}
