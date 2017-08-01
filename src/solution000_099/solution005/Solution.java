package solution000_099.solution005;

/**
 * Script Created by daidai on 2017/7/25.
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = Integer.MIN_VALUE;
        for (int strLen = chars.length; strLen >= 0; strLen--) {
            for (int j = 0; j + strLen <= chars.length; j++) {
                if (isPalindrome(chars, j, strLen)) {
                    return s.substring(j, strLen + j);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(char[] chars, int j, int strLen) {
        int k = j + strLen - 1;
        while (j < k) {
            if (chars[j] != chars[k]) {
                return false;
            }
            j++;
            k--;
        }
        return true;
    }

    public String solve(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                end = i - (len - 1) / 2;
                start = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public String dp(String string) {
        int n = string.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int start = 0, end = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i; j < n; j++) {
                if (string.charAt(i) == string.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return string.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dp("abcda"));
    }
}
