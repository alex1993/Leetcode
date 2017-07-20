package solution300_399.solution398;

import java.util.Random;

/**
 * Script Created by daidai on 2017/4/16.
 */
public class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = i;
                break;
            }
        }

        Random random = new Random();
        int count = 1;
        for (int i = res + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextDouble() < 1.0 / count) {
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * Codec obj = new Codec(nums);
 * int param_1 = obj.pick(target);
 */
