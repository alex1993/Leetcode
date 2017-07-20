package solution100_199.solution188;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    buy[i] = Math.max(buy[i], 0 - price);
                } else {
                    buy[i] = Math.max(buy[i], sell[i - 1] - price);
                }
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[sell.length - 1];
    }

    private int quickSolve(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
