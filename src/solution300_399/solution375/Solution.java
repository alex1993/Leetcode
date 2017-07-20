package solution300_399.solution375;

/**
 * Script Created by daidai on 2017/5/29.
 */
public class Solution {

    public int getMoneyAmount(int n) {
        return DP(1, n, new int[n + 1][n + 1]);
    }

    private int DP(int s, int e, int[][] dp) {
        if (s >= e) {
            return 0;
        }
        if (dp[s][e] != 0) {
            return dp[s][e];
        }
        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            res = Math.min(res, i + Math.max(DP(s, i - 1, dp), DP(i + 1, e, dp)));
        }
        dp[s][e] = res;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMoneyAmount(10));
    }
}
