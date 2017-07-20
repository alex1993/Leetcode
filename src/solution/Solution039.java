package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/13.
 */
public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (candidates[i] <= target) {
                prefix.add(candidates[i]);
                solve(candidates, i, prefix, target - candidates[i], result);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution039 solution039 = new Solution039();
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(solution039.combinationSum(nums, 7));
    }
}
