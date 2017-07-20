package solution;

import java.util.*;

/**
 * Script Created by daidai on 2017/3/5.
 */
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        if (k == 0) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            int result = 0;
            for (Integer num : counts.values()) {
                if (num > 1) {
                    result++;
                }
            }
            return result;
        }

        Set<Integer> numSet = new TreeSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int count = 0;
        for (Integer integer : numSet) {
            if (numSet.contains(integer + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution532 solution532 = new Solution532();
        System.out.println(solution532.findPairs(new int[]{1, 2, 1, 3, 4, 5}, 0));
    }
}
