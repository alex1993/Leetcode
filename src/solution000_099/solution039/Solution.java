package solution000_099.solution039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int[] candidates, int target, int level) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            prefix.add(candidates[i]);
            backTracking(res, prefix, candidates, target - candidates[i], i);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
