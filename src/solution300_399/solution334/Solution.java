package solution300_399.solution334;

/**
 * Script Created by daidai on 2017/6/12.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max >= 3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.increasingTriplet(new int[]{1, 2, 5}));
        System.out.println(solution.increasingTriplet(new int[]{2, 1, 3, 2}));
    }
}
