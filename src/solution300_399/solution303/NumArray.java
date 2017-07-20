package solution300_399.solution303;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/3/29.
 */
public class NumArray {

    private final int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(Arrays.toString(numArray.dp));
        System.out.println(numArray.sumRange(0, 2));
//        System.out.println(numArray.sumRange(2, 5));
//        numArray.update(1, 2);
//        System.out.println(numArray.sumRange(0, 5));

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
