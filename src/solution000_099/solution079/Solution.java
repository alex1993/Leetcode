package solution000_099.solution079;

/**
 * Script Created by daidai on 2017/4/15.
 */
public class Solution {
    private int[][] dirs = new int[][]{
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        char[] chars = word.toCharArray();

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isMatch(board, i, j, chars, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMatch(char[][] board, int i, int j, char[] chars, int index, boolean[][] visited) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        if (visited[i][j] || board[i][j] != chars[index]) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (isMatch(board, row, col, chars, index + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        System.out.println(solution.exist(board, "ABCB"));
//        System.out.println(solution.exist(board, "SEE"));
//        System.out.println(solution.exist(board, "ABCCED"));
        char[][] board = new char[][] {
                {'a'}, {'a'}
        };
        System.out.println(solution.exist(board, "aaa"));
    }
}
