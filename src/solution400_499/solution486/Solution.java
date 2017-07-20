package solution400_499.solution486;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/5/30.
 */
public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return helper(nums,  0, nums.length - 1, memo) >= 0;
    }

    private int helper(int[] nums, int start, int end, Integer[][] memo) {
        if (start == end) {
            return nums[start];
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int left = nums[start] - helper(nums, start + 1, end, memo);
        int right = nums[end] - helper(nums, start, end - 1, memo);
        memo[start][end] = Math.max(left, right);
        return memo[start][end];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.PredictTheWinner(new int[]{1, 5, 237, 7}));

    }
}
