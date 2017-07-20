package solution100_199.solution153;

/**
 * Script Created by daidai on 2017/6/22.
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //minimum is on right
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{5, 6, 7, 0, 1, 2, 4}));
        System.out.println(solution.findMin(new int[]{6, 7, 0, 1, 2, 4}));
        System.out.println(solution.findMin(new int[]{1}));
    }
}
