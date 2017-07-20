package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/2/16.
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int solution(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        int[] integers = new int[]{1, 1, 2, 3, 4, 2, 3};
        System.out.println(solution136.solution(integers));
    }
}
