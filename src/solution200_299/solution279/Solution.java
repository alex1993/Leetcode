package solution200_299.solution279;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public int numSquares(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int root = (int) Math.sqrt(n);
        if (root * root == n) {
            cache.put(n, 1);
            return 1;
        }

        int res = n;
        for (int i = root; i >= 1; i--) {
            res = Math.min(res, helper(n - i * i) + 1);
        }
        cache.put(n, res);
        return res;
    }

    private int solve(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(14));
        System.out.println(solution.numSquares(15));
        System.out.println(solution.numSquares(16));
        System.out.println(solution.numSquares(7168));
    }
}
