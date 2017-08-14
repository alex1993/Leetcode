package solution500_599.solution501;

/**
 * Script Created by daidai on 2017/8/2.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private List<Integer> res = new ArrayList<>();
    private Integer lastVisit;
    private int maxCount;
    private int curCount;

    public int[] findMode(TreeNode root) {
        midOrder(root);
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    //中序遍历，然后统计当前数字出现的次数，如果当前数字和之前的数字不同，则清零，否则加1
    //当计数超过max时，清空更新res，否则添加结果
    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);

        if (lastVisit == null || root.val != lastVisit) {
            curCount = 0;
            lastVisit = root.val;
        }
        curCount++;
        if (curCount > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            res.add(root.val);
        }

        midOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMode(TreeNode.parse(new Integer[]{1, null, 2, 2}))));
    }
}
