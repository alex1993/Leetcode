package solution000_099.solution096;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numTrees(3);
    }
}
