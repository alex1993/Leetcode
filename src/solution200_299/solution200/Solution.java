package solution200_299.solution200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {

    class UnionFind {
        int[] father;
        int count;

        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            father = new int[m * n];
            for (int i = 0; i < father.length; i++) {
                int row = i / n;
                int col = i % n;
                if (grid[row][col] == '1') {
                    count++;
                }
                father[i] = i;
            }
        }

        void union(int x, int y) {
            int fatherX = find(x);
            int fatherY = find(y);
            if (fatherX != fatherY) {
                father[fatherX] = fatherY;
                count--;
            }
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        for (int i = 0; i < size; i++) {
            int row = i / n;
            int col = i % n;
            if (grid[row][col] == '0') {
                continue;
            }
            if (row > 0 && grid[row - 1][col] == '1') {
                unionFind.union(i, i - n);
            }
            if (col > 0 && grid[row][col - 1] == '1') {
                unionFind.union(i, i - 1);
            }
        }
        return unionFind.count;
    }

    public int solveDfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(grid, x - 1, y, visited);
        dfs(grid, x + 1, y, visited);
        dfs(grid, x, y - 1, visited);
        dfs(grid, x, y + 1, visited);
    }

    public int solveBfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                count++;
                bfs(grid, i, j, visited);
            }
        }
        return count;
    }

    //fixme: 会超时，如果把当前位置的状态修改了的话，就能够AC
    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == '1' && !visited[xx][yy]) {
                    grid[xx][yy] = '0';
                    queue.offer(new int[]{xx, yy});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        };
        System.out.println(solution.solveBfs(grid));
    }
}
