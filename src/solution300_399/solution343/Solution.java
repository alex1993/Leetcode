package solution300_399.solution343;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        //dp[n] 和等于 n 的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                //i 可以拆分为 j 和 i - j，注意有可能 dp[i - j] 可能比 i - j 还要小，所以要取一个更大的值
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(11));
    }
}
