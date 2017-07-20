package solution600_699.solution628;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(new int[]{-4, 1, 2, 3}));
    }
}
