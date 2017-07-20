package solution;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/3/8.
 */
public class Solution037 {
    public void solveSudoku(char[][] board) {
        boolean[][] rowOcp = new boolean[9][10];
        boolean[][] colOcp = new boolean[9][10];
        boolean[][] matOcp = new boolean[9][10];
        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;
            int matRow = row / 3;
            int matCol = col / 3;
            int matIndex = matRow * 3 + matCol;
            if (board[row][col] != '.') {
                int curNum = Character.getNumericValue(board[row][col]);
                rowOcp[row][curNum] = true;
                colOcp[col][curNum] = true;
                matOcp[matIndex][curNum] = true;
            }
        }
        backTracking(board, rowOcp, colOcp, matOcp, 0, new Stack<>());
        for (char[] chars : board) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }

    public void backTracking(char[][] board, boolean[][] rowOcp, boolean[][] colOcp, boolean[][] matOcp, int index, Stack<Character> validNums) {
        int row = index / 9;
        int col = index % 9;
        int matIndex = (row / 3) * 3 + col / 3;
        if (row < 9 && col < 9) {
            if (board[row][col] == '.') {
                for (int i = 1; i <= 9; i++) {
                    if (!rowOcp[row][i] && !colOcp[col][i] && !matOcp[matIndex][i]) {
                        validNums.add(Character.forDigit(i, 10));
                    }
                }
                if (validNums.size() > 0) {
                    Character top = validNums.pop();
                    int val = Character.getNumericValue(top);
                    board[row][col] = top;
                    rowOcp[row][val] = true;
                    colOcp[col][val] = true;
                    matOcp[matIndex][val] = true;
                    backTracking(board, rowOcp, colOcp, matOcp, index + 1, validNums);
                    validNums.push(top);
                }
            } else {
                backTracking(board, rowOcp, colOcp, matOcp, index + 1, validNums);
            }
        }
    }

    private char[][] strings2chars(String[] strings) {
        char[][] res = new char[strings.length][strings.length];
        for (int i = 0; i < strings.length; i++) {
            res[i] = strings[i].toCharArray();
        }
        return res;
    }

    public void solution(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                        board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution037 solution037 = new Solution037();
        String[] strings = new String[]{
                "..9748...",
                "7........",
                ".2.1.9...",
                "..7...24.",
                ".64.1.59.",
                ".98...3..",
                "...8.3.2.",
                "........6",
                "...2759.."
        };
        solution037.solve(solution037.strings2chars(strings));
    }
}
