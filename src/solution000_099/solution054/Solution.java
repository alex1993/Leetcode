package solution000_099.solution054;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = m * n;

        int[] start = new int[]{0, -1};
        int d = 0;
        while (count > 0) {
            //往某一个方向移动
            for (int i = 0; i < n; i++) {
                start[0] += dirs[d][0];
                start[1] += dirs[d][1];
                res.add(matrix[start[0]][start[1]]);
                count--;
            }
            //每次如果水平方向移动，那么垂直方向的长度就会相应 - 1
            //同理如果垂直方向移动，水平方向减一，始终用 n 来标识要移动的次数
            int tmp = m;
            m = n;
            n = tmp;

            n--;
            //切换方向
            d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(matrix));
    }
}
