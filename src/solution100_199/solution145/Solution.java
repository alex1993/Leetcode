package solution100_199.solution145;

/**
 * Script Created by daidai on 2017/8/3.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    class NodeState {
        TreeNode node;
        boolean visited;

        public NodeState(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            NodeState nodeState = stack.peek();
            if (!nodeState.visited) {
                nodeState.visited = true;
                TreeNode node = nodeState.node;
                if (node.right != null) {
                    stack.push(new NodeState(node.right, false));
                }
                if (node.left != null) {
                    stack.push(new NodeState(node.left, false));
                }
            } else {
                res.add(stack.pop().node.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(TreeNode.parse(new Integer[]{1, null, 2, 3})));
    }
}
