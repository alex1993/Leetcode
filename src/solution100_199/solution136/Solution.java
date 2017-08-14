package solution100_199.solution136;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
