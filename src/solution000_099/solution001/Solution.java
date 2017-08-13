package solution000_099.solution001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/1.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Solution solution001 = new Solution();
        System.out.println(Arrays.toString(solution001.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
