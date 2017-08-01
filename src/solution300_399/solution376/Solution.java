package solution300_399.solution376;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int start = 1;
        while ((start < nums.length) && (nums[start] == nums[start - 1]))
            start++;
        if (start == nums.length)
            return 1;

        boolean increasing = nums[start] > nums[0];   // denoting if we are expecting increased relative to prev
        int prev = nums[0], maxLen = 1;
        for (int i = start; i < nums.length; i++) {
            if ((increasing && (nums[i] > prev)) || (!increasing && (nums[i] < prev))) {
                increasing = !increasing;
                maxLen++;
            }
            prev = nums[i];
        }
        return maxLen;
    }

    public int solve(int[] nums) {
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
        return Math.max(down[n - 1], up[n - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 4, 5}));
        System.out.println(solution.wiggleMaxLength(new int[]{1, 1, 4, 1, 2, 5}));
    }
}
