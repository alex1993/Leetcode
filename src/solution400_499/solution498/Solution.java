package solution400_499.solution498;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/30.
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0;

        int row = 0, col = 0, d = 1;
        for (int i = 0; i < m * n; i++) {
            res[index++] = matrix[row][col];
            row -= d;
            col += d;
            //检查顺序有一定要求
            //out of bottom boarder
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = -d;
            }
            //out of right boarder
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = -d;
            }
            //out of up boarder
            if (row < 0) {
                row = 0;
                d = -d;
            }
            //out of left boarder
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[3][3];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ++count;
            }
        }
        int[] diagonalOrder = solution.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}