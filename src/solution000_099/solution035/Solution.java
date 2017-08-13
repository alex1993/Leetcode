package solution000_099.solution035;

/**
 * Script Created by daidai on 2017/8/6.
 */
public class Solution {
    //lower bound, 在一个有序数组中找到第一个 >= target 的元素位置
    //upper bound， 找到第一个 > target 的元素的位置
    // [1, 2, 3, 3, 3, 4, 5] target = 3 -> lower bound return 2
    // upper bound return 5
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        //有两点需要注意，一个是 循环条件是 low <= high，和通常的 two pointers 不一样
        //另一个是 判断条件 nums[mid] >= target（lower bound），因为需要找到相同元素的最左边界
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
    }
}
