package solution000_099.solution073;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 1}
        };
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
