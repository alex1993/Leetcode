package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/3/7.
 */
public class Solution036 {

    public boolean isSudoku(char[][] board) {
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
                if (!rowOcp[row][curNum] && !colOcp[col][curNum] && !matOcp[matIndex][curNum]) {
                    rowOcp[row][curNum] = true;
                    colOcp[col][curNum] = true;
                    matOcp[matIndex][curNum] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String rowCheck = board[i][j] + " in row " + i;
                    String colCheck = board[i][j] + " in column " + j;
                    String matCheck = board[i][j] + " in matrix " + i / 3 + "-" + j / 3;
                    if (!seen.add(rowCheck) || !seen.add(colCheck) || !seen.add(matCheck)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> copy = new HashSet<Character>(9) {
            {
                add('1');
                add('2');
                add('3');
                add('4');
                add('5');
                add('6');
                add('7');
                add('8');
                add('9');
            }
        };
        Set<Character> numSet = new HashSet<>(9);
        for (int i = 0; i < board.length; i++) {
            numSet.addAll(copy);
            if (!checkRow(board, i, numSet)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            numSet.addAll(copy);
            if (!checkCol(board, i, numSet)) {
                return false;
            }
        }

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                numSet.addAll(copy);
                if (!checkMat(board, i, j, numSet)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean checkRow(char[][] board, int row, Set<Character> numSet) {
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != '.') {
                if (!numSet.contains(board[row][i])) {
                    return false;
                } else {
                    numSet.remove(board[row][i]);
                }
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col, Set<Character> numSet) {
        int rowNum = board.length;
        for (int i = 0; i < rowNum; i++) {
            if (board[i][col] != '.') {
                if (!numSet.contains(board[i][col])) {
                    return false;
                } else {
                    numSet.remove(board[i][col]);
                }
            }
        }
        return true;
    }

    private boolean checkMat(char[][] board, int row, int col, Set<Character> numSet) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int curRow = row + i;
                int curCol = col + j;
                if (board[curRow][curCol] != '.') {
                    if (!numSet.contains(board[curRow][curCol])) {
                        System.out.println(curRow + " " + curCol);
                        return false;
                    } else {
                        numSet.remove(board[curRow][curCol]);
                    }
                }
            }
        }
        return true;
    }

    private char[][] strings2chars(String[] strings) {
        char[][] res = new char[strings.length][strings.length];
        for (int i = 0; i < strings.length; i++) {
            res[i] = strings[i].toCharArray();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution036 solution036 = new Solution036();

        String[] strings = new String[]{
                ".87654321",
                "2........",
                "3........",
                "4........",
                "5........",
                "6........",
                "7........",
                "8........",
                "9........"
        };
        char[][] board = solution036.strings2chars(strings);
        System.out.println(solution036.isSudoku(board));
    }

}
