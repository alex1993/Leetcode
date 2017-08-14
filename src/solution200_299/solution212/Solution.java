package solution200_299.solution212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {

    class Trie {
        Trie[] next;
        boolean exists;
        String word;

        Trie() {
            next = new Trie[26];
        }
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            //Trie每次从跟开始重新搜索
            Trie root = trie;
            for (char c : word.toCharArray()) {
                if (root.next[c - 'a'] == null) {
                    root.next[c - 'a'] = new Trie();
                }
                root = root.next[c - 'a'];
            }
            root.exists = true;
            root.word = word;
        }
        return trie;
    }

    private int[][] dirs = new int[][]{
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int m = board.length;
        int n = board[0].length;
        Trie trie = buildTrie(words);
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backTracking(res, board, i, j, visited, trie);
            }
        }
        return new ArrayList<>(res);
    }

    private void backTracking(Set<String> res, char[][] board, int i, int j, boolean[][] visited, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        Trie next = trie.next[c - 'a'];
        //如果发现当前单次已经没有在 Trie 中，则提前结束
        if (next == null) {
            return;
        }
        //如果当前节点是一个词，则加入结果中
        if (next.exists) {
            res.add(next.word);
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            backTracking(res, board, i + dir[0], j + dir[1], visited, next);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        System.out.println(solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }
}
