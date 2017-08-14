package solution000_099.solution039;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/2.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> prefix, int target, int level) {
        if (target == 0) {
            res.add(new ArrayList<>(prefix));
        }
        for (int i = level; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                prefix.add(candidates[i]);
                backTracking(candidates, res, prefix, target - candidates[i], i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{1}, 7));
    }
}
