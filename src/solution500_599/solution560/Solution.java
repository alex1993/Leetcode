package solution500_599.solution560;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/12.
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        int n = preSum.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (preSum[j] - preSum[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    public int solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, }, 2));
    }
}
