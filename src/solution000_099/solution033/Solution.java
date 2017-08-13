package solution000_099.solution033;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[high]) {
                //left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {
                //right part is sorted
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                high--;
            }
        }
        return -1;
    }

    public int solve(int[] nums, int target) {
        //先找到旋转点，注意是 low < high，当 low 和 high 重合的时候就已经找到旋转点了
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                //pivot is on right
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int pivot = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int readMid = (mid + pivot) % nums.length;
            if (nums[readMid] == target) {
                return readMid;
            }
            if (nums[readMid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(solution.search(new int[]{3, 1, 1}, 3));
    }
}
