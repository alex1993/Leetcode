package solution600_699.solution655;

/**
 * Script Created by daidai on 2017/8/6.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    class TreeNodeIndex {
        TreeNode root;
        int index;
        TreeNodeIndex(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int level = level(root);
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            lists.add(new ArrayList<>());
        }
        for (List<String> list : lists) {
            for (int i = 0; i < Math.pow(2, level) - 1; i++) {
                list.add("");
            }
        }

        int curLevel = 0;
        Queue<TreeNodeIndex> queue = new LinkedList<>();
        queue.add(new TreeNodeIndex(root, ((int)Math.pow(2, level) - 1) / 2));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeIndex treeNodeIndex = queue.poll();
                TreeNode node = treeNodeIndex.root;
                int id = treeNodeIndex.index;
                int delta = (int) Math.pow(2, level - 2);
                if (node.left != null) {
                    queue.add(new TreeNodeIndex(node.left, id - delta));
                }
                if (node.right != null) {
                    queue.add(new TreeNodeIndex(node.right, id + delta));
                }
                lists.get(curLevel).set(id, node.val + "");
            }
            curLevel++;
            level--;
        }
        return lists;
    }

    private int level(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(level(root.left), level(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.printTree(TreeNode.parse(new Integer[]{1, 2, null})));
        System.out.println(solution.printTree(TreeNode.parse(new Integer[]{1, 2, 3, null, 4})));
        System.out.println(solution.printTree(TreeNode.parse(new Integer[]{1, 2, 5, 3, null, null, null, 4})));
    }
}
