package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/14.
 */

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        getPaths(root, new ArrayList<>(), result);
        return result;
    }

    private void getPaths(TreeNode root, List<String> prefix, List<String> result) {
        prefix.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", prefix));
        } else {
            if (root.left != null) {
                getPaths(root.left, prefix, result);
            }
            if (root.right != null) {
                getPaths(root.right, prefix, result);
            }
        }
        prefix.remove(prefix.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 7, 6, 4, 5, null, 10};
        TreeNode treeNode = TreeNode.parse(integers);
        Solution257 main257 = new Solution257();
        List<String> strings = main257.binaryTreePaths(treeNode);
        System.out.println(strings);
    }


}
