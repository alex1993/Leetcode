package solution400_499.solution493;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/2.
 */
public class Solution {
    public int reversePairs(int[] nums) {
        long[] copy = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return helper(copy, 0, nums.length - 1);
    }

    private int helper(long[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        int left = helper(nums, s, mid);
        int right = helper(nums, mid + 1, e);
        int mergeCount = merge(nums, s, mid, mid + 1, e);
        return left + right + mergeCount;
    }

    private int merge(long[] nums, int s1, int e1, int s2, int e2) {
        int count = 0;
        long[] tmp = new long[e1 - s1 + 1 + e2 - s2 + 1];
        int i = s1, j = s2, k = 0;
        while (i <= e1 && j <= e2) {    //正常来说统计逆序数，就直接把技术和排序放在一块了，但是由于对逆序的定义不同，可以直接先计算逆序
            if (nums[i] > 2 * nums[j]) {
                count += (e1 - i + 1);
                j++;
            } else {
                i++;
            }
        }
        i = s1;
        j = s2;

        while (i <= e1 && j <= e2) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= e1) {
            tmp[k++] = nums[i++];
        }
        while (j <= e2) {
            tmp[k++] = nums[j++];
        }

        i = s1;
        for (int m = 0; m < tmp.length; m++) {
            nums[i++] = tmp[m];
        }
        return count;
    }

    //统计逆序数
    private int calReversePairs(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        int left = divideConquer(nums, s, mid);
        int right = divideConquer(nums, mid + 1, e);
        int merge = mergeAndCount(nums, s, mid, mid + 1, e);
        return left + right + merge;
    }

    private int mergeAndCount(int[] nums, int s1, int e1, int s2, int e2) {
        int[] tmp = new int[e2 - s2 + 1 + e1 - s1 + 1];
        int count = 0;
        int i = s1, j = s2;
        int k = 0;
        while (i <= e1 && j <= e2) {
            if (nums[i] <= nums[j]) {   //一般的逆序数是 nums[i] <= nums[j]
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                count += (e1 - i + 1);
            }
        }
        while (i <= e1) {
            tmp[k++] = nums[i++];
        }
        while (j <= e2) {
            tmp[k++] = nums[i++];
        }

        i = s1;
        for (int m = 0; m < tmp.length; m++) {
            nums[i++] = tmp[m];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
