package solution200_299.solution229;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int k = 3;
        int[] candidates = new int[k];
        int[] counts = new int[k];
        for (int num : nums) {
            boolean settled = false;
            for (int i = 0; i < k; i++) {
                if (num == candidates[i]) {
                    counts[i]++;
                    settled = true;
                    break;
                }
            }
            if (settled) {
                continue;
            }

            settled = false;
            for (int i = 0; i < k; i++) {
                if (counts[i] == 0) {
                    counts[i]++;
                    candidates[i] = num;
                    settled = true;
                    break;
                }
            }
            if (settled) {
                continue;
            }

            for (int i = 0; i < k; i++) {
                counts[i] = Math.max(0, counts[i] - 1);
            }

        }

        List<Integer> res = new ArrayList<>();
        Arrays.fill(counts, 0);
        for (int num : nums) {
            for (int i = 0, candidatesLength = candidates.length; i < candidatesLength; i++) {
                int candidate = candidates[i];
                if (num == candidate) {
                    counts[i]++;
                    break;
                }
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > nums.length / 3) {
                res.add(candidates[i]);
            }
        }
        return res;
    }

    public List<Integer> solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int len = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{0, 0, 0}));
    }
}
