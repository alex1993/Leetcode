package solution200_299.solution287;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        //要查找的数在 low 和 high 之间，每次用 mid 和所有的数比较并计数，如果超过了 mid 个
        //则在小的那半边，否则就在大的那边
        //当 low 和 high相同的时候，已经找到该元素了…所以循环的条件是 low < high
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int count = 0;
            int mid = low + (high - low) / 2;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            //如果 <= mid 的个数正好有 mid 个，说明在 1 - mid 之间恰好都是 1 个，说明重复的在更高那边
            //如果超过了 mid 个，也有可能恰好是 mid，所以 high = mid
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 1}));
    }
}
