package solution000_099.solution078;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTracking(res, new ArrayList<>(), nums, 0, i);
        }
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int[] nums, int level, int height) {
        if (prefix.size() == height) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = level; i < nums.length; i++) {
            prefix.add(nums[i]);
            backTracking(res, prefix, nums, i + 1, height);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
