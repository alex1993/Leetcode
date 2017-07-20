package solution100_199.solution152;

/**
 * Script Created by daidai on 2017/4/1.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int iMax = nums[0], iMin = nums[0], res = nums[0];
        int tmp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            res = Math.max(res, iMax);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{-1, -2, -9, -6}));
    }
}
