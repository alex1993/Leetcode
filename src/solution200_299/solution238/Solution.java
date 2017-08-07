package solution200_299.solution238;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2})));
    }
}
