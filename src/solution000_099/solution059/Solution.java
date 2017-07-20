package solution000_099.solution059;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/5/25.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //right, down, left, up
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},};

        int i = 0;
        int[] pos = new int[]{0, -1};
        int d = 0;
        int m = n;
        int length = n * n;
        while (i < length) {
            for (int j = 0; j < n; j++) {
                i++;
                pos[0] += dirs[d][0];
                pos[1] += dirs[d][1];
                res[pos[0]][pos[1]] = i;
            }
            int tmp = m;
            m = n;
            n = tmp;
            n--;
            d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(5)));
    }
}
