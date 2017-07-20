package solution100_199.solution121;

/**
 * Script Created by daidai on 2017/6/8.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(res, price - min);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
