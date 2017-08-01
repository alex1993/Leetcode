package solution400_499.solution449;

/**
 * Script Created by daidai on 2017/7/30.
 */

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> strings = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                strings.add("#");
            } else {
                strings.add(node.val + "");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (strings.size() > 0 && strings.get(strings.size() - 1).equals("#")) {
            strings.remove(strings.size() - 1);
        }
        return String.join(",", strings);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.split(",").length == 0) {
            return null;
        }
        String[] strings = data.split(",");
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = strings[i].equals("#") ? null : Integer.parseInt(strings[i]);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(integers[0]);
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < integers.length) {
                if (integers[index] != null) {
                    node.left = new TreeNode(integers[index]);
                    queue.offer(node.left);
                }
                index++;
            }
            if (index < integers.length) {
                if (integers[index] != null) {
                    node.right = new TreeNode(integers[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }

    public String preOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = preOrder(root.left);
        String right = preOrder(root.right);
        return root.val + (left.equals("") ? "" : ",") + left + (right.equals("") ? "" : ",") + right;
    }

    public TreeNode dePreOrder(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] strings = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String string : strings) {
            queue.offer(Integer.parseInt(string));
        }
        return helper(queue);
    }

    private TreeNode helper(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Integer val = queue.poll();
        TreeNode node = new TreeNode(val);
        Queue<Integer> smaller = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < val) {
            smaller.offer(queue.poll());
        }
        node.left = helper(smaller);
        node.right = helper(queue);
        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = TreeNode.parse(new Integer[]{5, 2, 7, 1, 4, 6, 9});
        String serialize = codec.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        TreeNode.levelPrint(deserialize);
        codec.deserialize("");

        String s = codec.preOrder(node);
        System.out.println(s);
        TreeNode treeNode = codec.dePreOrder(s);
        TreeNode.levelPrint(treeNode);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
