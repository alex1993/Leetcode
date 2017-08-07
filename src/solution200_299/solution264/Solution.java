package solution200_299.solution264;

/**
 * Script Created by daidai on 2017/8/2.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int index0 = 0, index1 = 0, index2 = 0;
        int factor0 = 2, factor1 = 3, factor2 = 5;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(factor0, Math.min(factor1, factor2));
            if (dp[i] == factor0) {
                index0++;
                factor0 = dp[index0] * 2;
            }
            if (dp[i] == factor1) {
                index1++;
                factor1 = dp[index1] * 3;
            }
            if (dp[i] == factor2) {
                index2++;
                factor2 = dp[index2] * 5;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1));
        System.out.println(solution.nthUglyNumber(2));
        System.out.println(solution.nthUglyNumber(3));
        System.out.println(solution.nthUglyNumber(4));
        System.out.println(solution.nthUglyNumber(5));
        System.out.println(solution.nthUglyNumber(9));
    }
}
