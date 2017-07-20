package solution200_299.solution221;

import util.ParseUtil;
import util.PrintUtil;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/23.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;

        //height表示当前点能够达到的最大高度
        int[][] height = new int[m][n];

        //left表示当前点能够达到的最左长度
        int[][] left = new int[m][n];

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                height[0][j] = 1;
                left[0][j] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                left[i][0] = 1;
                height[i][0] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = Math.min(height[i - 1][j], height[i - 1][j - 1]) + 1;
                    left[i][j] = Math.min(left[i][j - 1], left[i - 1][j - 1]) + 1;
                } else {
                    height[i][j] = 0;
                    left[i][j] = 0;
                }
                int tmp = Math.min(left[i][j], height[i][j]);
                res = Math.max(res, tmp * tmp);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String m = "[\"0010\",\"1111\",\"1111\",\"1110\",\"1100\",\"1111\",\"1110\"]";
        PrintUtil.printMatrix(m);

        char[][] matrix = ParseUtil.parseMatrix(m);
        System.out.println(solution.maximalSquare(matrix));
    }
}
