package solution300_399.solution377;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/2.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int target, int[] cache) {
        if (cache[target] != -1) {
            return cache[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            res += helper(nums, target - nums[i], cache);
        }
        cache[target] = res;
        return res;
    }

    private int iterative(int[] nums, int target) {
        Arrays.sort(nums);

        //dp[i]表示能够凑齐到 i 的所有组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //当前数 i 能够凑齐的方式，是由所有比 target 小的数的 two sum的组合和，即 i 能够由 dp[i] + dp[i - j]组合而成
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.iterative(new int[]{1, 2}, 4));
    }
}
