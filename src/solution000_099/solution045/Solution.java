package solution000_099.solution045;

/**
 * Script Created by daidai on 2017/5/20.
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int level = 0, currentMax = 0, i = 0, nextMax = 0;
        while (i <= currentMax) {
            level++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}
