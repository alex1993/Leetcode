package solution100_199.solution179;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/23.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] numsString = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            numsString[i] = String.valueOf(nums[i]);

        Arrays.sort(numsString, (s1, s2) -> {
            String sum1 = s1 + s2;
            String sum2 = s2 + s1;
            return sum2.compareTo(sum1);
        });

        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(numsString[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: numsString)
            sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{121, 12}));
    }
}
