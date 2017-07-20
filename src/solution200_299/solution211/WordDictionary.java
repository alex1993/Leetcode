package solution200_299.solution211;

/**
 * Script Created by daidai on 2017/4/15.
 */
public class WordDictionary {

    class Node {
        char c;
        Node[] next;
        boolean exists;
        Node(char c) {
            this.c = c;
            this.next = new Node[26];
        }

        @Override
        public String toString() {
            return "Node{" +
                           "c=" + c +
                           '}';
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node dump = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (dump.next[index] == null) {
                dump.next[index] = new Node(c);
            }
            dump = dump.next[index];
        }
        dump.exists = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);
    }

    private boolean isMatch(char[] chars, int index, Node curNode) {
        if (index == chars.length) {
            return curNode.exists;
        }
        if (chars[index] != '.') {
            return curNode.next[chars[index] - 'a'] != null && isMatch(chars, index + 1, curNode.next[chars[index] - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (curNode.next[i] != null) {
                    if (isMatch(chars, index + 1, curNode.next[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("..d"));
        System.out.println(wordDictionary.search("k.d"));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
