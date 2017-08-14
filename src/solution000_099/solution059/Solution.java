package solution000_099.solution059;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }
        int m = n;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 1;
        int total = n * n;

        int[][] matrix = new int[n][n];
        int[] start = new int[]{0, -1};
        int dir = 0;
        while (count <= total) {
            for (int i = 0; i < n; i++) {
                start[0] += dirs[dir][0];
                start[1] += dirs[dir][1];
                matrix[start[0]][start[1]] = count;
                count++;
            }

            int tmp = m;
            m = n;
            n = tmp;
            n--;
            dir = (dir + 1) % 4;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
    }
}
