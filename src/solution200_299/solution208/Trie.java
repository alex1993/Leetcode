package solution200_299.solution208;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/4/13.
 */
public class Trie {

    class TreeNode {
        char c;
        boolean exist;
        TreeNode[] next = new TreeNode[26];

        @Override
        public String toString() {
            return "TreeNode{" +
                           "c=" + c +
                           ", exist=" + exist +
                           '}';
        }
    }

    TreeNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if ("".equals(word)) {
            return;
        }
        char[] chars = word.toCharArray();
        TreeNode dump = node;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (dump.next[index] != null) {
                dump = dump.next[index];
                continue;
            }
            TreeNode tmp = new TreeNode();
            tmp.c = aChar;
            dump.next[index] = tmp;
            dump = tmp;
        }
        dump.exist = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode dump = node;
        int index = -1;
        for (char c : word.toCharArray()) {
            index = c - 'a';
            if (dump.next[index] == null) {
                return false;
            }
            dump = dump.next[index];
        }
        return dump.exist;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode dump = node;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (dump.next[index] == null) {
                return false;
            }
            dump = dump.next[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        trie.insert("hello");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("a"));
    }
}
