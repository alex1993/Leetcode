package solution200_299.solution297;

/**
 * Script Created by daidai on 2017/6/21.
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
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (first == null) {
                    list.add("null");
                    continue;
                }
                list.add(first.val + "");
                queue.add(first.left);
                queue.add(first.right);
            }

        }
        while (list.size() > 0 && list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        return "[" + String.join(", ", list) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.trim().substring(1, data.length() - 1)
                               .split(", ");
        if (strings.length == 0 || (strings.length == 1 && strings[0].equals(""))) {
            return null;
        }
        Integer[] nums = new Integer[strings.length];
        for (int i = 0, stringsLength = strings.length; i < stringsLength; i++) {
            if ("null".equals(strings[i])) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(strings[i]);
            }
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 1;
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            if (index < nums.length) {
                if (nums[index] != null) {
                    first.left = new TreeNode(nums[index]);
                    queue.add(first.left);
                }
                index++;
            }
            if (index < nums.length) {
                if (nums[index] != null) {
                    first.right = new TreeNode(nums[index]);
                    queue.add(first.right);
                }
                index++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Codec code = new Codec();
        String serialize = code.serialize(TreeNode.parse(new Integer[]{1, 2, null, 3}));
        System.out.println(serialize);
        TreeNode deserialize = code.deserialize(serialize);
        TreeNode.levelPrint(deserialize);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
