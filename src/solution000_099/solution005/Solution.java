package solution000_099.solution005;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public String longestPalindrome(String s) {
        //分别以char[i] 和 char[i]\char[i + 1] 扩充字符串，找到最长的回文
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //判断扩充字符串的最大长度，注意最后多减了和加了1，所以长度为 j - i - 1
    private int extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public String solve(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        //dp[i][j] 表示子串 i...j 是回文字符串
        //因此有 dp[i][j] = (dp[i + 1][j - 1] || j - i <= 2) && chars[i] == chars[j]
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i >= end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("cbbd"));
    }
}