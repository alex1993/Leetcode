package solution300_399.solution376;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(solution.wiggleMaxLength(new int[]{}));
        System.out.println(solution.wiggleMaxLength(new int[]{1}));
        System.out.println(solution.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
