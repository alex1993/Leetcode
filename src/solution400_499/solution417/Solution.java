package solution400_499.solution417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Script Created by daidai on 2017/4/2.
 */
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        Set<int[]> toPac = new HashSet<>();
        Set<int[]> toAlt = new HashSet<>();
        System.out.println(dfsPac(matrix, 1, 3));
        System.out.println(dfsAlt(matrix, 1, 3));
        return res;
    }

    boolean dfsPac(int[][] matrix, int x, int y) {
        int height = matrix[x][y];
        if (x == 0 || y == 0) {
            return true;
        }
        if (matrix[x - 1][y] <= height) {
            return dfsPac(matrix, x - 1, y);
        }
        if (matrix[x][y - 1] <= height) {
            return dfsPac(matrix, x, y - 1);
        }
        if (x + 1 < matrix.length && matrix[x + 1][y] <= height) {
            return dfsPac(matrix, x + 1, y);
        }
        if (y + 1 < matrix[0].length && matrix[x][y + 1] <= height) {
            return dfsPac(matrix, x, y + 1);
        }
        return false;
    }

    boolean dfsAlt(int[][] matrix, int x, int y) {
        int height = matrix[x][y];
        if (x == matrix.length - 1 || y == matrix[0].length - 1) {
            return true;
        }
        return ((x > 0 && matrix[x - 1][y] <= height) && dfsAlt(matrix, x - 1, y)) ||
                       (y > 0 && matrix[x][y - 1] <= height && dfsAlt(matrix, x, y - 1)) ||
                       (matrix[x + 1][y] <= height && dfsAlt(matrix, x + 1, y)) ||
                       (matrix[x][y + 1] <= height && dfsAlt(matrix, x, y + 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }
}
