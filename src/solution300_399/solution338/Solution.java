package solution300_399.solution338;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num -= (num & -num);
//            num = (num & (num - 1));
        }
        return res;
    }

    public int[] solve(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(5)));
    }
}

