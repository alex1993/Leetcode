package solution100_199.solution129;

/**
 * Script Created by daidai on 2017/8/3.
 */

import structure.TreeNode;

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
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res, 0);
        int sum = 0;
        for (Integer num : res) {
            sum += num;
        }
        return sum;
    }

    private void preOrder(TreeNode root, List<Integer> res, int prefix) {
        if (root == null) {
            return;
        }
        prefix = prefix * 10 + root.val;
        if (root.left == null && root.right == null) {
            res.add(prefix);
        } else {
            preOrder(root.left, res, prefix);
            preOrder(root.right, res, prefix);
        }
        prefix = prefix / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(TreeNode.parse(new Integer[]{})));
    }
}
