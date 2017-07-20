package solution500_599.solution598;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int i = 0; i < ops.length; i++) {
            minRow = Math.min(minRow, ops[i][0]);
            minCol = Math.min(minCol, ops[i][1]);
        }
        return minRow * minCol;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
