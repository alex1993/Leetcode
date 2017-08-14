package solution400_499.solution416;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }

    //fixme: TLE runtime is O(2 ^ n)
    public boolean solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        return helper(nums, nums.length - 1, sum, new boolean[sum + 1]);
    }

    private boolean helper(int[] nums, int n, int sum, boolean[] cache) {
        if (sum < 0) {
            return false;
        }
        if (cache[sum]) {
            return true;
        }
        if (sum == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        // cur is too big, continue to next element
        if (nums[n] > sum) {
            helper(nums, n - 1, sum, cache);
        }
        // include or exclude current element
        cache[sum] = helper(nums, n - 1, sum - nums[n], cache) || helper(nums, n - 1, sum, cache);
        return cache[sum];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{}));
    }

}