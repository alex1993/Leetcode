package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Script Created by daidai on 2017/3/22.
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                TreeNode first = queue.poll();
                tmp.add(first.val);
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                size--;
            }
            res.add(0, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse(new Integer[]{});
        Solution107 solution107 = new Solution107();
        System.out.println(solution107.levelOrderBottom(root));
    }
}
