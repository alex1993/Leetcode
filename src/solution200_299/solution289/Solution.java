package solution200_299.solution289;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/1.
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m + 2][n + 2];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                copy[i][j] = board[i - 1][j - 1];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int count = countNeighbours(i, j, copy);
                if (copy[i][j] == 1) {
                    if (count != 2 && count != 3) {
                        board[i - 1][j - 1] = 0;
                    }
                } else {
                    if (count == 3) {
                        board[i - 1][j - 1] = 1;
                    }
                }
            }
        }
    }

    private int countNeighbours(int i, int j, int[][] copy) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (copy[k][l] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(ints);
        System.out.println(Arrays.deepToString(ints));
    }

}
