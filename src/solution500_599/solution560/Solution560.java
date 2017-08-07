package solution500_599.solution560;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/1.
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    private int solve(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int solveHashMap(int[] nums, int k) {
        //map 用来保存 sum 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.solveHashMap(new int[]{1, 1, 1, 1}, 4));
    }
}
