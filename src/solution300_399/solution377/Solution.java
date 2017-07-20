package solution300_399.solution377;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/20.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        Arrays.fill(res, -1);
        res[0] = 1;
        return dynamicProgramming(res, target, nums);
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(prefix));
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            prefix.add(nums[i]);
            backTracking(res, prefix, nums, target - nums[i]);
            prefix.remove(prefix.size() - 1);
        }
    }

    private int dynamicProgramming(int[] res, int target, int[] nums) {
        if (res[target] != -1) {
            return res[target];
        }
        int count = 0;
        for (int num : nums) {
            if (target >= num) {
                count += dynamicProgramming(res, target - num,  nums);
            }
        }
        res[target] = count;
        return count;
    }

    private int iterative(int[] nums, int target) {
        //res[i]表示达到 i 的可能组合数
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    res[i] += res[i - num];
                }
            }
        }
        return res[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.iterative(new int[]{1, 2, 3}, 10));
    }
}
