package solution500_599.solution515;

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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, 0, res);
        return res;
    }

    private void preOrder(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        preOrder(root.left, level + 1, res);
        preOrder(root.right, level + 1, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestValues(TreeNode.parse(new Integer[]{1, 3, 2, 5, 3, null, 9})));
    }
}
