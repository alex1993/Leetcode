package solution400_499.solution416;

/**
 * Script Created by daidai on 2017/5/29.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 2D DP initialization
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        // dp function
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = sum / 2; j >= nums[i - 1]; j--) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }

        return dp[nums.length][sum / 2];
    }

    public boolean solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 2, 5}));
    }

}
