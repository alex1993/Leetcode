package solution200_299.solution283;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/27.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        for (int i = 0; i < count; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0, 0};
        solution.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
