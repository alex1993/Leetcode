package solution200_299.solution260;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/9.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0, resSize = res.size(); i < resSize; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private int[] solve(int[] nums) {
        int temp = 0;
        for (int n : nums) {
            temp ^= n;
        }
        System.out.println(Integer.toBinaryString(temp));
        System.out.println(Integer.toBinaryString(-temp));
        int mask = -temp & temp;

        int single1 = 0, single2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                single1 ^= num;
            } else {
                single2 ^= num;
            }
        }
        return new int[] {single1, single2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
