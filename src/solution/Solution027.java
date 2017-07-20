package solution;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/2/18.
 */
public class Solution027 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        Solution027 solution027 = new Solution027();
        System.out.println(solution027.removeElement2(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
