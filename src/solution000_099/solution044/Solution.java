package solution000_099.solution044;

/**
 * Script Created by daidai on 2017/8/1.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        dp[0][0] = true;

        //initialize, match p with empty string, if char is *, then it follows previous
        for (int j = 1; j < n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //if character equals or is ?, then follow previous
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //* can be replaced by zero or multiple character
                    dp[i][j] = (dp[i][j - 1] || dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("", ""));
    }
}
