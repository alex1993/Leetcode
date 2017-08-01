package pinduoduo;

/**
 * Script Created by daidai on 2017/7/21.
 */
public class FindMin {
    //nums[0] > nums[1] and nums[n - 2] < nums[n - 1]
    //find an element such a[i - 1] >= a[i] <= a[i + 1]
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int solve(int[] nums) {
        int low = 1, high = nums.length - 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{10, 9, 8, 2, 15}));
        System.out.println(findMin.solve(new int[]{10, 9, 8, 2, 15}));
    }
}
