package solution300_399.solution313;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int[] index = new int[primes.length];
        int[] factor = Arrays.copyOf(primes, primes.length);

        for (int i = 1; i < n; i++) {
            //找到各个factor的最小值，作为当前i的结果
            int min = min(factor);
            res[i] = min;
            //更新factor
            for (int j = 0; j < factor.length; j++) {
                if (factor[j] == min) {
                    index[j] += 1;
                    factor[j] = res[index[j]] * primes[j];
                }
            }
        }
        return res[n - 1];
    }

    private int min(int[] factor) {
        int res = Integer.MAX_VALUE;
        for (int i : factor) {
            if (i < res) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(10, new int[]{2, 3, 5}));
    }
}
