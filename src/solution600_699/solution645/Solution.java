package solution600_699.solution645;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/7/23.
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        long sum = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                dup = num;
            }
            sum += num;
        }

        int n = nums.length;
        long origin = ((1 + n) * n) / 2;
        int missing = (int)(dup - (sum - origin));
        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, })));
    }
}
