package solution300_399.solution324;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int leftSize = (int) Math.ceil((double) nums.length / 2);
        int rightSize = nums.length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = nums[leftSize - i - 1];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = nums[nums.length - i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = left[i / 2];
            } else {
                nums[i] = right[i / 2];
            }
        }
    }

    private void solve(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int k = (nums.length - 1) / 2;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[k--];
        }
        k = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[k--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2, 1, 2, 2, 1};
        solution.solve(nums);
        System.out.println(Arrays.toString(nums));
    }
}
