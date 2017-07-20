package solution000_099.solution052;

/**
 * Script Created by daidai on 2017/5/20.
 */

import java.util.*;

/**
 * Script Created by daidai on 2017/5/20.
 */
public class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> dig = new HashSet<>();
        Set<Integer> rev = new HashSet<>();
        backTracking(n, res, row, col, dig, rev, 0, 0);
        return res[0];
    }

    public void backTracking(int n, int[] result, Set<Integer> row, Set<Integer> col, Set<Integer> dig, Set<Integer> rev, int prev, int R) {
        if (prev == n) {
            result[0]++;
        }
        for (int j = 0; j < n; j++) {
            if (!valid(row, col, dig, rev, R, j)) {
                continue;
            }
            update(row, col, dig, rev, R, j);
            prev++;

            backTracking(n, result, row, col, dig, rev, prev, R + 1);

            prev--;
            ret(row, col, dig, rev, R, j);
        }

    }

    public boolean valid(Set<Integer> row, Set<Integer> col, Set<Integer> dig, Set<Integer> rev, int i, int j) {
        return !(row.contains(i) || col.contains(j) || dig.contains(i - j) || rev.contains(i + j));
    }

    public void update(Set<Integer> row, Set<Integer> col, Set<Integer> dig, Set<Integer> rev, int i, int j) {
        row.add(i);
        col.add(j);
        dig.add(i - j);
        rev.add(i + j);
    }

    public void ret(Set<Integer> row, Set<Integer> col, Set<Integer> dig, Set<Integer> rev, int i, int j) {
        row.remove(i);
        col.remove(j);
        dig.remove(i - j);
        rev.remove(i + j);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}

