package solution100_199.solution116;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Script Created by daidai on 2017/4/22.
 */
// Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode parse(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(integers[0]);
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeLinkNode first = queue.pollFirst();
            if (index < integers.length) {
                if (integers[index] != null) {
                    first.left = new TreeLinkNode(integers[index]);
                    queue.add(first.left);
                }
                index++;
            }
            if (index < integers.length) {
                if (integers[index] != null) {
                    first.right = new TreeLinkNode(integers[index]);
                    queue.add(first.right);
                }
                index++;
            }
        }
        return root;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int i = 0;
            List<TreeLinkNode> nodes = new ArrayList<>();
            while (i < queueSize) {
                TreeLinkNode first = queue.poll();
                nodes.add(first);
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                i++;
            }
            for (int j = 0; j < nodes.size() - 1; j++) {
                nodes.get(j).next = nodes.get(j + 1);
            }

        }
    }

    public void con(TreeLinkNode treeLinkNode) {
        if (treeLinkNode == null) {
            return;
        }
        helper(treeLinkNode.left, treeLinkNode.right);
    }

    private void helper(TreeLinkNode left, TreeLinkNode right) {
        if (left == null) {
            return;
        }
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeLinkNode nodes = TreeLinkNode.parse(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        solution.connect(nodes);

    }


}
