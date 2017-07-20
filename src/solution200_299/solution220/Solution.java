package solution200_299.solution220;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0 || k < 1) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        if (t == 0) {
            return containsNearbyAlmostDuplicate(nums, k);
        }
        for (int i = 0; i < nums.length; i++) {
            long reMapNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = reMapNum / t;
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && reMapNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - reMapNum <= t)) {
                return true;
            }

            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / t;
                map.remove(lastBucket);
            }

            map.put(bucket, reMapNum);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            if (set.size() >= k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647));
    }
}
