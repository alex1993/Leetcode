package solution100_199.solution123;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        int start = 0;
        for (int price : prices) {
            hold1 = Math.max(hold1, start - price);
            sell1 = Math.max(sell1, hold1 + price);
            hold2 = Math.max(hold2, sell1 - price);
            sell2 = Math.max(sell2, hold2 + price);
        }

        return sell2;
    }

    private int solve(int[] prices) {
        int k = 2;
        int[] hold = new int[k];
        Arrays.fill(hold, Integer.MIN_VALUE);
        int[] sell = new int[k];

        int start = 0;
        for (int price : prices) {
            for (int i = k - 1; i >= 0; i--) {
                sell[i] = Math.max(sell[i], hold[i] + price);
                if (i > 0) {
                    hold[i] = Math.max(hold[i], sell[i - 1] - price);
                } else {
                    hold[i] = Math.max(hold[i], start - price);
                }
            }
        }
        return sell[sell.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 4, 6, 1, 3}));
    }
}
