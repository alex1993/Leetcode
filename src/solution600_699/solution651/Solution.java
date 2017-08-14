package solution600_699.solution651;

/**
 * Script Created by daidai on 2017/8/1.
 */
public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 3; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxA(9));
    }
}
