package solution300_399.solution378;

import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = queue.poll();
            if (tuple.x == n - 1) {
                continue;
            }
            queue.add(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return queue.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    private int solve(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int index = getLessThan(matrix, mid);
            if (index < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int getLessThan(int[][] matrix, int mid) {
        int n = matrix.length;
        int i = n - 1, j = 0;
        int res = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                res += (i + 1);
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

}
