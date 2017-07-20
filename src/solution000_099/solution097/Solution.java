package solution000_099.solution097;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp表示s1, s2长度分别为 i，j，是否能够组成的字符串s3
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        //因为dp[i][j] 始终是由 dp[i - 1][j] 或者 dp[i][j - 1] 演化而来
        //所以 dp[i][j] = a || b
        // a = dp[i - 1][j] && s1[i] == s3[i + j]
        // b = dp[i][j - 1] &&　s2[j] == s3[i + j]

        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                boolean a = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                boolean b = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                dp[i][j] = a || b;
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "adabbbccca"));
    }
}
