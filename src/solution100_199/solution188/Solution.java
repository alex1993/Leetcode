package solution100_199.solution188;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        int[] hold = new int[k];
        Arrays.fill(hold, Integer.MIN_VALUE);
        int[] sell = new int[k];

        //第 i 次买入的手里剩下的钱是 hold[i]
        //hold[i] = Math.max(hold[i], sell[i - 1] - price)
        //表示要么保持原样，要么买入当前股票
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                hold[i] = Math.max(hold[i], (i == 0 ? 0 : sell[i - 1]) - price);
                sell[i] = Math.max(sell[i], hold[i] + price);
            }
        }
        return sell[k - 1];
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
        System.out.println(solution.maxProfit(1, new int[]{3,3,5,0,0,3,1,4}));
    }
}
