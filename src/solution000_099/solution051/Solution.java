package solution000_099.solution051;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/20.
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> dig = new HashSet<>();
        Set<Integer> rev = new HashSet<>();
        backTracking(n, res, row, col, dig, rev, new ArrayList<>(), 0);
        return res;
    }

    public void backTracking(int n, List<List<String>> result, Set<Integer> row, Set<Integer> col, Set<Integer> dig, Set<Integer> rev, List<String> prev, int R) {
        if (prev.size() == n) {
            result.add(new ArrayList<>(prev));
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int j = 0; j < n; j++) {
            if (!valid(row, col, dig, rev, R, j)) {
                continue;
            }
            chars[j] = 'Q';
            update(row, col, dig, rev, R, j);
            prev.add(new String(chars));

            backTracking(n, result, row, col, dig, rev, prev, R + 1);

            prev.remove(prev.size() - 1);
            ret(row, col, dig, rev, R, j);
            chars[j] = '.';
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
        System.out.println(solution.solveNQueens(4));
    }
}
