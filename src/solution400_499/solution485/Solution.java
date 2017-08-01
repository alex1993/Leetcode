package solution400_499.solution485;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            }
            if (nums[i] == 1) {
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
