package solution300_399.solution338;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/4.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countBit(i);
        }
        return res;
    }

    private int countBit(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n -= (n & -n);
        }
        return count;
    }

    private int[] solve(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBits(6)));
    }
}
