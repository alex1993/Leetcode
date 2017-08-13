package solution000_099.solution088;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i];
                i--;
            } else {
                nums1[k--] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        solution.merge(nums1, 3, new int[]{2, 3, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
