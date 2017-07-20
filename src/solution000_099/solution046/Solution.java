package solution000_099.solution046;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(res, nums, new ArrayList<>(), used);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, int level, List<Integer> prefix) {
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefix.contains(nums[i])){
                continue;
            }
            prefix.add(nums[i]);
            backTracking(res, nums, level + 1, prefix);
            prefix.remove(prefix.size() - 1);
        }
    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> prefix, boolean[] used){
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            prefix.add(nums[i]);
            used[i] = true;
            backTracking(res, nums, prefix, used);
            used[i] = false;
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
