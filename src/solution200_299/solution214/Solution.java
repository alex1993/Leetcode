package solution200_299.solution214;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("abcd"));
    }
}
