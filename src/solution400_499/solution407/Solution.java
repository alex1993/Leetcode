package solution400_499.solution407;

import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/4/10.
 */
public class Solution {
    public class Cell implements Comparable<Cell> {

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        int row;
        int col;
        int height;

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        PriorityQueue<Cell> cells = new PriorityQueue<>();

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        //init border
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            cells.offer(new Cell(i, 0, heightMap[i][0]));
            cells.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            cells.offer(new Cell(0, i, heightMap[0][i]));
            cells.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        //from the borders, pick the shortest one to visit and check its neighbours
        //if the neighbour is shorter, add it and update height
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!cells.isEmpty()) {
            Cell cell = cells.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                int height = cell.height;
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, height - heightMap[row][col]);
                    cells.offer(new Cell(row, col, Math.max(height, heightMap[row][col])));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        }));

    }
}
