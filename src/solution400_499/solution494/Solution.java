package solution400_499.solution494;

/**
 * Script Created by daidai on 2017/5/29.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findSum(nums, 0, S);
    }

    private int findSum(int[] nums, int s, int T) {
        if (s == nums.length) {
            return T == 0 ? 1 : 0;
        }
        return findSum(nums, s + 1, T - nums[s]) + findSum(nums, s + 1, T + nums[s]);
    }

    public int solve(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = (S + sum) / 2;
        return find(nums, target);
    }

    private int find(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
