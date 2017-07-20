package solution100_199.solution137;

import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/8.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        //统计各个位出现的 1 的次数
        int[] counter = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    counter[j]++;
                }
            }
        }

        //如果某一位不能整除 3，那么那个数的这一位不是 1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (counter[i] % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public int solve(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int num : nums) {
            x2 ^= (x1 & num);
            x1 ^= num;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 2, 3, 1, 2, 1, 2}));
    }
}
