package solution600_699.solution629;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    private int mod = 1_000_000_000 + 7;

    //dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1] + ... + dp[n - 1][k - n + 1]
    //dp[n][k + 1] = dp[n - 1][k + 1] + ... + dp[n - 1][k + 1 - n + 1]
    //minus to dp[n][k + 1] = dp[n][k] + dp[n - 1][k + 1] - dp[n - 1][k - n + 1]
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (k > n * (n - 1) / 2 || k < 0)
            return 0;
        if (k == 0 || k == n * (n - 1) / 2)
            return 1;
        long[][] dp = new long[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kInversePairs(1000, 1000));
    }
}
