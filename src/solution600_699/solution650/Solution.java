package solution600_699.solution650;

/**
 * Script Created by daidai on 2017/8/1.
 */
public class Solution {
    public int minSteps(int n) {
        //dp[i] 就是要达到 i 个需要的次数
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
//                    break;
                }
            }
        }
        return dp[n];
    }

    //为了得到 n 个，那么就需要 d 次 n/d 个copy，而每得到 d 个copy都需要执行d次
    //包括一次 copy 和 d-1 次paste，所以每次恰好需要增加 d 次结果
    private int solve(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(16));
        System.out.println(solution.solve(16));
    }
}