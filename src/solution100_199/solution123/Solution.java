package solution100_199.solution123;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/8.
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
        //hold[i]表示第 i 次买入的时候，剩下的钱，初始为 MIN_VALUE，
        //用户最初情况下用户只有 0 元，所以第一次买入的时候，剩下的钱是 -price，之后根据用户前一次出售剩下的钱做调整
        //即 hold[i] = Math.max(hold[i], sell[i - 1] - price) 在这一次买入需要花费 price元
        //如果这一次卖出，则 sell[i] = Math.max(sell[i], hold[i - 1] + price) 如果售出能够得到更高的钱
        int[] hold = new int[k];
        Arrays.fill(hold, Integer.MIN_VALUE);
        int[] sell = new int[k];
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    hold[i] = Math.max(hold[i], -price);
                } else {
                    hold[i] = Math.max(hold[i], sell[i - 1] - price);
                }
                sell[i] = Math.max(sell[i], hold[i] + price);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{7, 4, 6, 1, 3}));
    }
}
