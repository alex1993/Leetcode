package solution200_299.solution260;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        //a和b都只出现一次，那么a，b肯定至少有一位不相同，根据不相同的这一位分成两组
        //每一组都有一个元素只出现一次
        int diff = xor & (-xor);
        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
