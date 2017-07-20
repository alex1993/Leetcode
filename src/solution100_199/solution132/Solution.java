package solution100_199.solution132;

/**
 * Script Created by daidai on 2017/6/19.
 */
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        //pal[i...j] 表示从 i 到 j 是否是回文
        boolean[][] pal = new boolean[len][len];
        //dp[i]表示到字符 i 需要的cut数目
        int[] dp = new int[len];

        for (int right = 0; right < len; right++) {
            //最欢情况需要right下
            dp[right] = right;
            pal[right][right] = true;
            for (int left = 0; left <= right; left++) {
                //当前 left 和 right 字符相同，如果内部也是回文，那么整个也是回文
                if (s.charAt(left) == s.charAt(right) && (right - left <= 1 || pal[left + 1][right - 1])) {
                    if (left == 0) {
                        dp[right] = 0;
                    } else {
                        pal[left][right] = true;
                        dp[right] = Math.min(dp[left - 1] + 1, dp[right]);
                    }
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("aab"));
    }
}
