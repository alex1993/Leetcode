package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/13.
 */
public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, new ArrayList<>(), target, res);
        return res;

    }

    public void solve(int[] candidates, int index, List<Integer> prefix, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(prefix));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1])
                continue;
            if (candidates[i] <= target) {
                prefix.add(candidates[i]);
                solve(candidates, i + 1, prefix, target - candidates[i], result);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution040 solution039 = new Solution040();
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution039.combinationSum2(nums, 8));
    }

}
