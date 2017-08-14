package solution000_099.solution016;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/6.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int deltaRes = Math.abs(target - res);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                int delta = Math.abs(target - sum);
                if (delta < deltaRes) {
                    deltaRes = delta;
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0,0,0}, 1));
    }
}
