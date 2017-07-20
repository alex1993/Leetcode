package solution200_299.solution268;

/**
 * Script Created by daidai on 2017/4/19.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        double sum = nums.length * ((nums.length + 1) / 2.0);
        long curSum = 0;
        for (int num : nums) {
            curSum += num;
        }
        return (int) (sum - curSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0}));
    }
}