package solution400_499.solution486;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return helper(nums, 0, n - 1, memo) >= 0;
    }

    //helper表示从 start 到 end，一方和另一方的差值
    //一方拿走一个，自己的值往上涨，而对方拿走，相当于值下降，最后只需要判断自己剩下的值是否 >= 0
    //需要判断取走左边还是右边最后剩下的值会最大
    private int helper(int[] nums, int start, int end, Integer[][] memo) {
        if (start == end) {
            return nums[start];
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int left = nums[start] - helper(nums, start + 1, end, memo);
        int right = nums[end] - helper(nums, start, end - 1, memo);
        memo[start][end] = Math.max(left, right);
        return memo[start][end];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.PredictTheWinner(new int[]{1, 5, 2}));
    }
}
