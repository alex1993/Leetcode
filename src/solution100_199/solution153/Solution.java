package solution100_199.solution153;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                //left part is sorted
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
