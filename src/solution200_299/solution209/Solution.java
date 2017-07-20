package solution200_299.solution209;

/**
 * Script Created by daidai on 2017/6/1.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int begin = 0, end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            end++;

            while (sum >= s) {
                if (end - begin < len) {
                    len = end - begin;
                }
                sum -= nums[begin];
                begin++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
