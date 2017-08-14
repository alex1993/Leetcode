package solution100_199.solution152;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(max, res);
        }
        return res;
    }

    //min和max分别表示长度为 i 的数组的最大值和最小值，如果当前的值小于0
    //那么 min[i] = Math.min(max[i - 1] * nums[i], nums[i])
    public int solve(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];

        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
            } else {
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 2, 9, -6}));
    }
}
