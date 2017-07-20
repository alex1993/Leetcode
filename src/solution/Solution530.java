package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/26.
 */
public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        System.out.println(result);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) - result.get(i-1) < minDiff) {
                minDiff = result.get(i) - result.get(i-1);
            }
        }
        return minDiff;

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

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse(new Integer[]{2, 1});
        Solution530 solution530 = new Solution530();
        System.out.println(solution530.getMinimumDifference(root));
    }
}
