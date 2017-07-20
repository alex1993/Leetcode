package solution200_299.solution212;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/4/15.
 */
public class Solution {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode dump = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (dump.next[c - 'a'] == null) {
                    dump.next[c - 'a'] = new TrieNode();
                }
                dump = dump.next[c - 'a'];
            }
            dump.word = word;
        }
        return root;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res, visited);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res, boolean[][] visited) {
        char c = board[i][j];
        if (visited[i][j] || root.next[c - 'a'] == null) {
            return ;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        visited[i][j] = true;

        if (i > 0) {
            dfs(board, i - 1, j, root, res, visited);
        }
        if (j > 0) {
            dfs(board, i, j - 1, root, res, visited);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, root, res, visited);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, root, res, visited);
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
        String[] words = new String[]{"oath", "pea", "eat", "oeii"};
        System.out.println(solution.findWords(board, words));
    }

}
