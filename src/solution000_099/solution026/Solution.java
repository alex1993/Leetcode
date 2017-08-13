package solution000_099.solution026;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}
