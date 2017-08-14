package solution100_199.solution154;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                //left is sorted, pivot is on right
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                //right is sorted, pivot is on left
                high = mid;
            } else {
                //如果有重复的元素，并且中间元素和 high 相同，那么 pivot 可能在左边也可能在右边
                //但是肯定不是 nums[high]
                high--;
            }
        }
        return nums[low];
    }
}
