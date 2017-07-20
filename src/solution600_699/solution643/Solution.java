package solution600_699.solution643;

/**
 * Script Created by daidai on 2017/7/16.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        long sum = 0;
        long res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                sum += nums[i];
                continue;
            }
            sum += nums[i];
            res = Math.max(res, sum);
            sum -= nums[i - (k - 1)];
        }
        return (res * 1.0) / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
