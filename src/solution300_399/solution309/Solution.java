package solution300_399.solution309;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //buy[i]意思是在 i 天之前，任意的序列，这个序列以 buy 结尾
        //同理 sell[i] 是在 i 天之前，最多的 sell 金额
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                buy[i] = -prices[i];
                sell[i] = 0;
                cool[i] = 0;
                continue;
            }
            int price = prices[i];
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
            cool[i] = Math.max(cool[i - 1], Math.max(buy[i - 1], sell[i - 1]));
        }
        return sell[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
