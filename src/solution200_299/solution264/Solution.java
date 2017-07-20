package solution200_299.solution264;

/**
 * Script Created by daidai on 2017/6/16.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int index1 = 0, index2 = 0, index3 = 0;
        int factor1 = 2, factor2 = 3, factor3 = 5;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int minimum = Math.min(factor1, Math.min(factor2, factor3));
            dp[i] = minimum;
            if (minimum == factor1) {
                index1 += 1;
                factor1 = dp[index1] * 2;
            }
            if (minimum == factor2) {
                index2 += 1;
                factor2 = dp[index2] * 3;
            }
            if (minimum == factor3) {
                index3 += 1;
                factor3 = dp[index3] * 5;
            }
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }

}
