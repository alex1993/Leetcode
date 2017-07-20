package solution200_299.solution216;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/3.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), k, n, 0, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int k, int n, int s, int total) {
        if (prefix.size() == k) {
            if (total == n) {
                res.add(new ArrayList<>(prefix));
            } else {
                return;
            }
        }
        for (int i = s + 1; i < 10; i++) {
            prefix.add(i);
            backTracking(res, prefix, k, n, i, i + total);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }
}
