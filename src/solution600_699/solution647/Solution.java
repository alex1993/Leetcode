package solution600_699.solution647;

import util.ParseUtil;

/**
 * Script Created by daidai on 2017/7/23.
 */
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }

    //fixme: wrong answer
    public int solve(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    public int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        int res = helper(s, i, j - 1, memo) + helper(s, i + 1, j, memo) - helper(s, i + 1, j - 1, memo);
        if (s.charAt(i) == s.charAt(j)) {
            res++;
        }
        memo[i][j] = res;
        return res;
    }

    public int palindrome(String string) {
        char[] chars = string.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res += extendPalindrome(string, i, i);
            res += extendPalindrome(string, i, i + 1);
        }
        return res;
    }

    private int extendPalindrome(String string, int i, int j) {
        int count = 0;
        while (i >= 0 && j < string.length()) {
            if (string.charAt(i) == string.charAt(j)) {
                i--;
                j++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.palindrome("aaa"));
    }
}