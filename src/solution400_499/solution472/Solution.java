package solution400_499.solution472;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/6.
 */
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (testWord(word.toCharArray(), 0, trie, 0)) {
                res.add(word);
            }
        }

        return res;
    }

    public boolean testWord(char[] chars, int index, Trie root, int count) { // count means how many words during the search path
        Trie cur = root;
        int n = chars.length;
        for (int i = index; i < n; i++) {
            if (cur.next[chars[i] - 'a'] == null) {
                return false;
            }
            if (cur.next[chars[i] - 'a'].exist) {
                if (i == n - 1) { // no next word, so test count to get result.
                    return count >= 1;
                }
                if (testWord(chars, i + 1, root, count + 1)) {
                    return true;
                }
            }
            cur = cur.next[chars[i] - 'a'];
        }
        return false;
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            Trie root = trie;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.next[chars[i] - 'a'] == null) {
                    root.next[chars[i] - 'a'] = new Trie();
                }
                root = root.next[chars[i] - 'a'];
            }
            root.exist = true;
        }
        return trie;
    }

    class Trie {
        Trie[] next;
        boolean exist;
        Trie() {
            next = new Trie[26];
        }

        @Override
        public String toString() {
            return "Trie{" +
                       "next=" + Arrays.toString(next) +
                       ", exist=" + exist +
                       '}';
        }
    }

    public List<String> findWords(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

        List<String> res = new ArrayList<>();
        //只有长度大于自身的单次才有可能被用来组合单词，所以先排了序，然后逐渐把自身加到字典中
        Set<String> dict = new TreeSet<>();
        for (String word : words) {
            if (canFind(word, dict)) {
                res.add(word);
            }
            dict.add(word);
        }
        return res;
    }

    private boolean canFind(String word, Set<String> dict) {
        //dp[i] 表示前 i 个字符是否可以经过dict组合而成，那么对于 dp[i]有，dp[i] = dp[j] && dict.contains(word.subStr(j, i))
        //即当，dp[j]：前j个字符可以组合，并且j-i字符组成的子串可以被包含时，才表示字符i为真
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 0; i < word.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAllConcatenatedWordsInADict(new String[]{"cats", "dog", "catsdog", ""}));
    }
}
