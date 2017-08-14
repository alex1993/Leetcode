package solution000_099.solution032;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/8/3.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //dp[i]表示以 i 结尾的子串的匹配括号长度，所以还需要一个max来统计最终的结果
        //当前为左括号的时候，dp[i]就是0，但是需要对左括号计数
        //当前为有括号，并且 前边有左括号 的时候，dp[i] = dp[i - 1] + 2 + (dp[i - dp[i]])
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        //计算(的个数
        int open = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
            } else {
                if (open > 0) {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i] >= 0) {
                        dp[i] += dp[i - dp[i]];
                    }
                    open--;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("((()))"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("()((()"));
        System.out.println(solution.longestValidParentheses(")()())()()("));
    }
}
