package solution600_699.solution648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/23.
 */
public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null) {
            return "";
        }
        Trie trie = buildTrie(dict);
        String[] strings = sentence.split(" ");

        List<String> res = new ArrayList<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            Trie root = trie;
            boolean found = false;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (root.next[c - 'a'] == null) {
                    break;
                }
                if (root.next[c - 'a'].exists) {
                    res.add(string.substring(0, i + 1));
                    found = true;
                    break;
                }
                root = root.next[c - 'a'];
            }
            if (!found) {
                res.add(string);
            }
        }
        return String.join(" ", res);
    }

    private Trie buildTrie(List<String> dict) {
        Trie trie = new Trie();
        for (String word : dict) {
            char[] chars = word.toCharArray();
            Trie root = trie;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (root.next[c - 'a'] == null) {
                    root.next[c - 'a'] = new Trie();
                }
                root = root.next[c - 'a'];
            }
            root.exists = true;
        }
        return trie;
    }

    class Trie {
        Trie[] next;
        boolean exists;

        Trie() {
            next = new Trie[26];
            exists = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(Arrays.asList("cat", "bat", "rat"), ""));
    }
}
