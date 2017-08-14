package solution200_299.solution297;

/**
 * Script Created by daidai on 2017/8/8.
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
        queue.offer(root);
        //序列化的时候，可以把当前为null的节点也加入进来，并将其转成null字符串
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add("null");
                continue;
            }
            list.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!list.isEmpty() && list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] strings = data.split(",");
        if (strings.length == 0) {
            return null;
        }

        Integer[] nums = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("null")) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(strings[i]);
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        //使用index来记录当前反序列化到哪一个位置了，这一个位置是队列中pop中的元素的孩子节点，并将其加到队列中
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < nums.length) {
                if (nums[index] != null) {
                    node.left = new TreeNode(nums[index]);
                    queue.offer(node.left);
                }
                index++;
            }
            if (index < nums.length) {
                if (nums[index] != null) {
                    node.right = new TreeNode(nums[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec code = new Codec();
        System.out.println(code.serialize(TreeNode.parse(new Integer[]{1, 2, 3, null, null, 4, 5})));
        TreeNode node = code.deserialize("1,2,3,null,null,4,5");
        TreeNode.levelPrint(node);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
