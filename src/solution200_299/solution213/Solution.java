package solution200_299.solution213;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int s, int e) {
        if (nums == null || s > e) {
            return 0;
        }
        if (s == e) {
            return nums[s];
        }
        int[] dp = new int[e - s + 1];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s + 1], dp[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + s], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public int solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1));
    }

    private int solve(int[] nums, int s, int e) {
        int include = 0, exclude = 0;
        for (int i = s; i <= e; i++) {
            int includeTmp = include, excludeTmp = exclude;
            include = exclude + nums[i];
            exclude = Math.max(includeTmp, excludeTmp);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1}));
    }
}
