package solution400_499.solution414;

import java.util.Objects;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer num : nums) {
            if (Objects.equals(num, max1) || Objects.equals(num, max2) || Objects.equals(num, max3)) {
                continue;
            }
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(new int[]{1,2,-2147483648}));
    }
}
