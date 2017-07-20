package solution000_099.solution054;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/4/16.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int[][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        }; //right, down, left, up

        int m = matrix.length;
        int n = matrix[0].length;
        int i = m * n;

        // start from pos [0, -1]
        int[] pos = new int[]{0, -1};

        //move right first
        int d = 0;
        while (i > 0) {
            //n is the number of move counts
            for (int j = 0; j < n; j++) {
                i--;
                pos[0] += dirs[d][0];
                pos[1] += dirs[d][1];
                res.add(matrix[pos[0]][pos[1]]);
            }
            //swap between row and col model
            int tmp = m;
            m = n;
            n = tmp;
            //decrease the size
            n--;
            //switch move direction
            d = (d + 1) % 4;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{
                {2}, {3}
        }));
    }
}
