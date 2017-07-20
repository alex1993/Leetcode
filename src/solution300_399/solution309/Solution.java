package solution300_399.solution309;

/**
 * Script Created by daidai on 2017/7/1.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];
        int start = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy[i] = -prices[i];
                sell[i] = 0;
                rest[i] = 0;
                continue;
            }
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(rest[i - 1], Math.max(buy[i - 1], sell[i - 1]));
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
