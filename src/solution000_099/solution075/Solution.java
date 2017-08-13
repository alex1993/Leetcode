package solution000_099.solution075;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            } else {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            } else if (i >= red && i < red + white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void solve(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) {
                swap(nums, i, second);
                second--;
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero);
                zero++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] colrs = new int[]{1, 2, 2, 2, 1, 0};
        solution.sortColors(colrs);
        System.out.println(Arrays.toString(colrs));
    }
}
