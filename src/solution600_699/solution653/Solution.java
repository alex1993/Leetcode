package solution600_699.solution653;

/**
 * Script Created by daidai on 2017/8/6.
 */

import structure.TreeNode;
import util.ParseUtil;

import java.util.ArrayList;
import java.util.List;

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int tmp = res.get(i) + res.get(j);
            if (tmp == k) {
                return true;
            } else if (tmp < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTarget(TreeNode.parse(new Integer[]{2, 1, 3}), 4));
    }
}
