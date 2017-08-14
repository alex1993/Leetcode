package solution000_099.solution053;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(i > 0 ? dp[i - 1] : 0, 0) + nums[i];
            res = Math.max(dp[i], res);
        }
        return res;
    }

    private int solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, -1}));
        System.out.println(solution.solve(new int[]{-1}));
    }
}
