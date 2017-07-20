package solution200_299.solution217;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
