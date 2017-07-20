package solution600_699.solution605;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/4.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //dp[i] means if the ith flowerbed can be flowered
        boolean[] dp = new boolean[flowerbed.length];
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] > 0) {
                dp[i] = true;
            }
        }

        int count = 0;
        if (dp.length == 1) {
            if (!dp[0]) {
                count++;
            }
            return count >= n;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                continue;
            }
            if (i == 0 && i < dp.length - 1) {
                dp[i] = !dp[i + 1];
                if (dp[i]) {
                    count++;
                }
                continue;
            }
            if (i > 0 && i == dp.length - 1) {
                dp[i] = !dp[i - 1];
                if (dp[i]) {
                    count++;
                }
                continue;
            }
            dp[i] = !(dp[i - 1] || dp[i + 1]);
            if (dp[i]) {
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{0}, 1));
    }
}
