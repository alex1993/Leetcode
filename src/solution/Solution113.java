package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/15.
 */
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sumElement = new ArrayList<>();
        rootToLeaf2(root, sumElement, result, sum);
        return result;
    }

    private void rootToLeaf2(TreeNode root, List<Integer> sumElement, List<List<Integer>> result, int target) {
        sumElement.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                result.add(new ArrayList<>(sumElement));
            }
        } else {
            if (root.left != null) {
                rootToLeaf2(root.left, sumElement, result, target - root.val);
            }
            if (root.right != null) {
                rootToLeaf2(root.right, sumElement, result, target - root.val);
            }
        }
        sumElement.remove(sumElement.size() - 1);

    }

    private void rootToLeaf(TreeNode root, List<Integer> sumElement, List<List<Integer>> result, int target) {
        sumElement.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer integer : sumElement) {
                sum += integer;
            }
            if (sum == target) {
                result.add(new ArrayList<>(sumElement));
            }
        } else {
            if (root.left != null) {
                rootToLeaf(root.left, sumElement, result, target);
            }
            if (root.right != null) {
                rootToLeaf(root.right, sumElement, result, target);
            }
        }
        sumElement.remove(sumElement.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNode.parse(ints);
        Solution113 solution113 = new Solution113();
        List<List<Integer>> lists = solution113.pathSum(treeNode, 22);
        System.out.println(lists);
    }
}
