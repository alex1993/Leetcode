package solution200_299.solution213;

/**
 * Script Created by daidai on 2017/4/1.
 */
public class Solution {
    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int low, int high) {
        int inPrev = 0, noPrev = 0;
        for (int i = low; i <= high; i++) {
            int inPrevTmp = inPrev;
            //include current house
            inPrev = Math.max(noPrev + nums[i], nums[i]);
            //not include current, so choose noPrev or inPrev;
            noPrev = Math.max(inPrevTmp, noPrev);
        }
        return Math.max(inPrev, noPrev);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 9, 3}));
    }
}
