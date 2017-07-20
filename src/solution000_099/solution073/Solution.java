package solution000_099.solution073;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/3.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < cols.length; j++) {
            if (cols[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.setZeroes(new int[][]{
            {1, 2, 3},
            {0, 1, 4},
            {4, 5, 0}
        });
    }
}
