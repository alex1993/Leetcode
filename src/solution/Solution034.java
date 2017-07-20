package solution;

/**
 * Script Created by daidai on 2017/3/5.
 */
public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        int low = index - 1, high = index + 1;
        while (low >= 0 && nums[low] == target) {
            low--;
        }
        while (high < nums.length && nums[high] == target) {
            high++;
        }
        return new int[] {low + 1, high - 1};
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(nums, target, low, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, high);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution034 solution034 = new Solution034();
        int[] result = solution034.searchRange(new int[]{1}, 1);
        System.out.println(result[0] + " " + result[1]);
    }
}
