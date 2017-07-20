package solution400_499.solution456;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/6.
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    s3 = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(solution.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(solution.find132pattern(new int[]{10, 18, 20, 3, 16}));
    }
}
