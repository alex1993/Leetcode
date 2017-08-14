package solution600_699.solution647;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //dp[i][j]表示 i...j 的回文字符串的个数
        //flag表示是否是回文， flag[i][j] = true  when flag[i + 1][j - 1] && (char[i] == char[j] || j - i < 2)
        //dp[i][j] = dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j - 1]
        //如果 i...j是回文，则额外 + 1
        int[][] dp = new int[n][n];
        boolean[][] flag = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            flag[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                if (s.charAt(i) == s.charAt(j) && (flag[i + 1][j - 1] || j - i < 2)) {
                    dp[i][j] += 1;
                    flag[i][j] = true;
                }
            }
        }
        return dp[0][n - 1];
    }

    public int solve(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += extendString(s, i, i);
            res += extendString(s, i, i + 1);
        }
        return res;
    }

    private int extendString(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
                i--;
                j++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("acd"));
    }
}
