package solution500_599.solution516;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    //计算一个字符串的回文 子序列 的长度
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //首尾字符相同，则长度是中间的长度 + 2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //否则首尾不能组成回文，是中间的较大的长度
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}
