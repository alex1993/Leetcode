package solution100_199.solution121;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            res = Math.max(res, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
