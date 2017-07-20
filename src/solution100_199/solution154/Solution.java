package solution100_199.solution154;

/**
 * Script Created by daidai on 2017/6/22.
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //min is on right, left is sorted
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                //min is on left(include cur), right is sorted
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{1, 3, 3}));
    }
}
