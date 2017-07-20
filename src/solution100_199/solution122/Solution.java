package solution100_199.solution122;

/**
 * Script Created by daidai on 2017/6/8.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sum += (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{6, 5, 3, 2, 9}));
    }
}
