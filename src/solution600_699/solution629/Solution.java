package solution600_699.solution629;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    private int mod = 1_000_000_000 + 7;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = -1;

        inversions(n, k, dp);
        return dp[n][k];
    }

    int inversions(int n, int k, int[][] dp) {
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        if (k == 0) {
            return dp[n][k] = 1;
        }
        if (n == 0) {
            return dp[n][k] = 0;
        }
        int j = 0, val = 0;
        for (j = 0; j < n && k - j >= 0; j++)
            val += inversions(n - 1, k - j, dp);
        dp[n][k] = val % mod;
        return val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kInversePairs(1000, 1000));
    }
}
