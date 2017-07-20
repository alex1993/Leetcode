package solution;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/16.
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode top = deque.pop();
                if (top.left != null) {
                    deque.add(top.left);
                }
                if (top.right != null) {
                    deque.add(top.right);
                }
                tmp.add(top.val);
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] integers = {3};
        TreeNode root = TreeNode.parse(integers);
        Solution102 solution102 = new Solution102();
        List<List<Integer>> lists = solution102.levelOrder(root);
        System.out.println(lists);
    }
}
