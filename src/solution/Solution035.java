package solution;

/**
 * Script Created by daidai on 2017/3/7.
 */
public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution035 solution035 = new Solution035();
        System.out.println(solution035.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution035.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution035.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution035.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
