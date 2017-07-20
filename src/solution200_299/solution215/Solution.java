package solution200_299.solution215;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {

    private void quickSort(int[] nums, int s, int e) {
        //when there is only one element...
        if (s >= e) {
            return;
        }
        int tmp = nums[s];
        int i = s, j = e;
        while (i < j) {
            //find first element smaller than tmp...
            while (i < j && nums[j] > tmp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            //find first element greater than tmp...
            while (i < j && nums[i] < tmp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = tmp;
        quickSort(nums, s, i - 1);
        quickSort(nums, i + 1, e);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }

    //找到排好序后的第 k 个元素
    private int findKthSmallest(int[] nums, int s, int e, int k) {
        int tmp = nums[s];
        int i = s, j = e;
        while (i < j) {
            //find first element smaller than tmp...
            while (i < j && nums[j] > tmp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            //find first element greater than tmp...
            while (i < j && nums[i] < tmp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = tmp;
        if (i == k) {
            return nums[i];
        }
        if (k <= i - 1) {
            return findKthSmallest(nums, s, i - 1, k);
        } else {
            return findKthSmallest(nums, i + 1, e, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, 12, 9, 6, 3, 7, 8};
        solution.quickSort(nums, 0, 6);
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.findKthLargest(new int[]{3}, 1));
    }


}
