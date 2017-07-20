package structure;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class HuffmanEncoding {

    static class TreeNode implements Comparable<TreeNode> {
        TreeNode left;
        TreeNode right;
        int fre;
        char c;

        public TreeNode(int fre) {
            this.fre = fre;
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.fre - o.fre;
        }
    }

    public TreeNode build(Map<Character, Integer> statistics) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : statistics.entrySet()) {
            TreeNode treeNode = new TreeNode(entry.getValue());
            treeNode.c = entry.getKey();
            queue.add(treeNode);
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            TreeNode parent = new TreeNode(node1.fre + node2.fre);
            parent.left = node1;
            parent.right = node2;
            queue.add(parent);
        }

        return queue.poll();
    }

    private Map<Character, String> codeDict(TreeNode root) {
        Map<Character, String> map = new HashMap<>();
        backTracking(root, new StringBuilder(), map);
        return map;
    }

    private void backTracking(TreeNode root, StringBuilder stringBuilder, Map<Character, String> map) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            map.put(root.c, stringBuilder.toString());
        }
        stringBuilder.append('0');
        backTracking(root.left, stringBuilder, map);
        stringBuilder.setLength(stringBuilder.length() - 1);

        stringBuilder.append('1');
        backTracking(root.right, stringBuilder, map);
        stringBuilder.setLength(stringBuilder.length() - 1);
    }

    private String encode(String s, Map<Character, String> codeDic) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(codeDic.get(c));
        }
        return sb.toString();
    }

    private List<Character> decode(String string, TreeNode root) {
        char[] chars = string.toCharArray();
        TreeNode tmp = root;
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                tmp = tmp.left;

            } else {
                tmp = tmp.right;
            }
            if (tmp.c != 0) {
                res.add(tmp.c);
                tmp = root;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
        Map<Character, Integer> statistics = new HashMap<Character, Integer>() {
            {
                put('h', 1);
                put('u', 2);
                put('f', 3);
                put('m', 3);
                put('a', 5);
                put('n', 3);
            }
        };
        TreeNode root = huffmanEncoding.build(statistics);
        Map<Character, String> codeDict = huffmanEncoding.codeDict(root);
        List<Character> res = huffmanEncoding.decode(huffmanEncoding.encode("huffman", codeDict), root);
        System.out.println(res);
    }
}
