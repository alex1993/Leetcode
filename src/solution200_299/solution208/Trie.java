package solution200_299.solution208;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Trie {

    class TreeNode {
        boolean exist;
        TreeNode[] next = new TreeNode[26];

    }

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if ("".equals(word)) {
            return;
        }
        char[] chars = word.toCharArray();
        TreeNode root = this.root;
        for (char c : chars) {
            int index = c - 'a';
            if (root.next[index] == null) {
                root.next[index] = new TreeNode();
            }
            root = root.next[index];
        }
        root.exist = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode dump = root;
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
        TreeNode dummy = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (dummy.next[index] == null) {
                return false;
            }
            dummy = dummy.next[index];
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
