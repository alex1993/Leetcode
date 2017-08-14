package solution100_199.solution198;

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
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int solve(int[] nums) {
        int include = 0, exclude = 0;
        for (int j = 0; j < nums.length; j++) {
            int includeTmp = include, excludeTmp = exclude;
            include = excludeTmp + nums[j];
            exclude = Math.max(excludeTmp, includeTmp);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 3, 2, 10, 4, 5}));
        System.out.println(solution.solve(new int[]{1, 3, 2, 10, 4, 5}));
    }
}
