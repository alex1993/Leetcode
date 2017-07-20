package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/19.
 */
public class Solution501 {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> nums = new ArrayList<>();
        traversalTree(root, nums);
        List<Integer> res = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            int curCnt = 1;
            int curNum = nums.get(i);
            while (i < nums.size() - 1 && nums.get(i).equals(nums.get(i+1))) {
                i++;
                curCnt++;
            }
            if (curCnt > maxCount) {
                res.clear();
                maxCount = curCnt;
            }
            if (curCnt >= maxCount) {
                res.add(curNum);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void traversalTree(TreeNode treeNode, List<Integer> nums) {
        if (treeNode.left != null) {
            traversalTree(treeNode.left, nums);
        }
        nums.add(treeNode.val);
        if (treeNode.right != null) {
            traversalTree(treeNode.right, nums);
        }
    }

    public int[] solution(TreeNode root) {
        traversal(root);
        modes = new int[modeCnt];
        modeCnt = 0;
        curCnt = 0;
        traversal(root);
        return modes;
    }

    private int curVal;
    private int curCnt = 0;
    private int maxCnt = 0;
    private int modeCnt = 0;
    private int[] modes;

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        handleValue(root.val);
        traversal(root.right);
    }

    private void handleValue(int value) {
        if (value != curVal) {
            curVal = value;
            curCnt = 0;
        }
        curCnt++;
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            modeCnt = 1;
        } else if (curCnt == maxCnt) {
            if (modes != null) {
                modes[modeCnt] = curVal;
            }
            modeCnt++;
        }
    }

    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }

    private void morrisTraversal(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                printVal(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    printVal(node.val);
                    node = node.right;
                }
            }
        }
    }

    private void printVal(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse(new Integer[] {6, 2, 7, 1, 4, null, 9, null, null, 3, 5, 8});
        Solution501 solution501 = new Solution501();
//        System.out.println(Arrays.toString(solution501.solve(root)));
        solution501.morrisTraversal(root);
    }

}
