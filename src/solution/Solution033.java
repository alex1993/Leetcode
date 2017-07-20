package solution;

/**
 * Script Created by daidai on 2017/3/5.
 */
public class Solution033 {
    public int search(int[] nums, int target) {
        //find rot point first by binary search
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int pivot = low;
        low = 0;
        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int real_mid = (pivot + mid) % nums.length;
            if (nums[real_mid] == target) {
                return real_mid;
            }
            if (nums[real_mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {3, 1};
        Solution033 solution033 = new Solution033();
        System.out.println(solution033.search(nums, 1));
        System.out.println(solution033.search(nums, 5));
        System.out.println(solution033.search(nums, 6));
        System.out.println(solution033.search(nums, 8));
        System.out.println(solution033.search(nums, 0));
        System.out.println(solution033.search(nums, 1));
        System.out.println(solution033.search(nums, 2));
        System.out.println(solution033.search(nums, -3));
        System.out.println(solution033.search(nums, 7));
        System.out.println(solution033.search(nums, 12));
    }


}
