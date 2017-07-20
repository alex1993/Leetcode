package structure;

import java.util.*;

/**
 * Script Created by daidai on 2017/2/14.
 */
// Definition for a binary tree node.

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode parse(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(integers[0]);
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode first = queue.pollFirst();
            if (index < integers.length) {
                if (integers[index] != null) {
                    first.left = new TreeNode(integers[index]);
                    queue.add(first.left);
                }
                index++;
            }
            if (index < integers.length) {
                if (integers[index] != null) {
                    first.right = new TreeNode(integers[index]);
                    queue.add(first.right);
                }
                index++;
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
    }

    public static void levelOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.pollFirst();
            result.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        }
    }

    public static void levelOrder2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int floor = 1;
        while (!queue.isEmpty()) {
            System.out.println(floor++);
            int curLevelSize = queue.size();
            int i = 0;
            while (i < curLevelSize) {
                TreeNode top = queue.poll();
                result.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                i++;
            }
        }
    }

    public List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> pre = new LinkedList<>();
        if (root == null) {
            return pre;
        }
        pre.add(root.val);
        pre.addAll(preOrderRecursive(root.left));
        pre.addAll(preOrderRecursive(root.right));
        return pre;
    }

    public static void preOrderIter(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            res.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void midOrderIter(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
    }

    static class NodeState {
        TreeNode node;
        boolean visited;

        NodeState(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public static void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));
        while (!stack.empty()) {
            NodeState top = stack.peek();
            if (top.visited) {
                stack.pop();
                res.add(top.node.val);
            } else {
                top.visited = true;
                if (top.node.right != null) {
                    stack.push(new NodeState(top.node.right, false));
                }
                if (top.node.left != null) {
                    stack.push(new NodeState(top.node.left, false));
                }
            }
        }
    }

    public static void midOrderIter2(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            //visit left firstly
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                //visit root secondly
                TreeNode top = stack.pop();
                res.add(top.val);

                //visit right lastly
                p = top.right;
            }
        }
    }

    public static void levelPrint(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (first == null) {
                    list.add(null);
                    continue;
                }
                list.add(first.val);
                queue.add(first.left);
                queue.add(first.right);
            }
        }
        while (list.size() > 0 && list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = TreeNode.parse(integers);
        List<Integer> result = new ArrayList<>();

    }
}
