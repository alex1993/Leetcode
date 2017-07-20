package solution500_599.solution581;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/5/14.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] target = Arrays.copyOf(nums, nums.length);
        Arrays.sort(target);

        int start = 0;
        for (; start < nums.length && nums[start] == target[start]; start++) {
        }

        int end = nums.length - 1;
        for (; end > start && nums[end] == target[end]; end--) {
        }

        return end - start + 1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}
