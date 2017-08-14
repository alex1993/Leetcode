package solution000_099.solution047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int[] nums, boolean[] used) {
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            prefix.add(nums[i]);
            used[i] = true;
            backTracking(res, prefix, nums, used);
            used[i] = false;
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{3, 3, 0, 3}));
    }

}