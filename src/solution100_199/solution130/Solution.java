package solution100_199.solution130;

import util.ParseUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Script Created by daidai on 2017/8/3.
 */
public class Solution {

    class UnionFind {
        int[] father;
        boolean[] hasEdge;

        UnionFind(char[][] board) {
            int m = board.length, n = board[0].length;
            father = new int[m * n];
            hasEdge = new boolean[m * n];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            for (int i = 0; i < hasEdge.length; i++) {
                int row = i / n;
                int col = i % n;
                hasEdge[i] = (board[row][col] == 'O' && (row == 0 || row == m - 1 || col == 0 || col == n - 1));
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            //将rootX指向了rootY
            father[rootX] = rootY;
            //所以重点是rootY的状态需要更新
            hasEdge[rootY] = hasEdge[rootX] || hasEdge[rootY];
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
    }

    public void solution(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(board);

        for (int i = 0; i < unionFind.hasEdge.length; i++) {
            int row = i / n, col = i % n;
            int up = row - 1, right = col + 1;
            if (up >= 0 && board[row][col] == board[up][col]) {
                unionFind.union(i, i - n);
            }
            if (right < n && board[row][col] == board[row][right]) {
                unionFind.union(i, i + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (board[i][j] == 'O' && !unionFind.hasEdge[unionFind.find(index)]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, n - 1, visited);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, visited);
            dfs(board, m - 1, i, visited);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != 'O') {
            return;
        }
        visited[i][j] = true;
        if (i < board.length - 2) {
            dfs(board, i + 1, j, visited);
        }
        if (j < board[0].length - 2) {
            dfs(board, i, j + 1, visited);
        }
        if (i > 0) {
            dfs(board, i - 1, j, visited);
        }
        if (j > 0) {
            dfs(board, i, j - 1, visited);
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void sol(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new Point(i, 0));
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new Point(i, n - 1));
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new Point(0, i));
            }
            if (board[m - 1][i] == 'O') {
                queue.add(new Point(m - 1, i));
            }
        }

        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            //visit point
            Point point = queue.poll();
            board[point.x][point.y] = '*';
            for (int[] dir : dirs) {
                int row = dir[0] + point.x;
                int col = dir[1] + point.y;
                if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'O') {
                    queue.add(new Point(row, col));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String bS = "[\"XOXX\",\"OXOX\",\"XOXO\",\"OXOX\",\"XOXO\",\"OXOX\"]";
        char[][] board = ParseUtil.parseMatrix(bS);
        solution.solution(board);
        System.out.println(Arrays.deepToString(board));
    }
}
