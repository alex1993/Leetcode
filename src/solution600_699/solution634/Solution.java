package solution600_699.solution634;

/**
 * Script Created by daidai on 2017/7/2.
 */
public class Solution {
    public int findDerangement(int n) {
        if (n <= 1) {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        int mod = 1_000_000_000 + 7;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((((i - 1) % mod) * ((dp[i - 1] + dp[i - 2]) % mod) % mod) % mod);
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDerangement(2));
        System.out.println(solution.findDerangement(3));
        System.out.println(solution.findDerangement(13));
    }
}
