package solution400_499.solution491;

import java.util.*;

/**
 * Script Created by daidai on 2017/8/14.
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backTracking(set, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return new ArrayList<>(set);
    }

    private void backTracking(Set<List<Integer>> res, List<Integer> prefix, int[] nums, int level, boolean[] used) {
        if (prefix.size() >= 2) {
            res.add(new ArrayList<>(prefix));
        }
        for (int i = level; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (prefix.size() == 0 || prefix.get(prefix.size() - 1) <= nums[i]) {
                prefix.add(nums[i]);
                used[i] = true;
                backTracking(res, prefix, nums, i + 1, used);
                used[i] = false;
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubsequences(new int[]{1, 2, 3, 2}));

        Set<List<Integer>> res = new HashSet<>();
        res.add(Arrays.asList(1, 2));
        res.add(Arrays.asList(1, 2));
        System.out.println(res);
    }
}
