package solution000_099.solution090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backTracking(res, i, 0, nums, new ArrayList<>());
        }
        return res;
    }

    private void backTracking(List<List<Integer>> res, int height, int level, int[] nums, List<Integer> prefix) {
        if (prefix.size() == height) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = level; i < nums.length; i++) {
            if (i > level && nums[i] == nums[i - 1]) {
                continue;
            }
            prefix.add(nums[i]);
            backTracking(res, height, i + 1, nums, prefix);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

}
