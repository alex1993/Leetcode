package solution000_099.solution077;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/3.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), 0, n, 0, k);
        return res;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> prefix, int s, int n, int count, int k) {
        if (prefix.size() == k) {
            res.add(new ArrayList<>(prefix));
        }
        for (int i = s + 1; i <= n; i++) {
            prefix.add(i);
            backTracking(res, prefix, i, n, count + 1, k);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(0, 0));
    }
}