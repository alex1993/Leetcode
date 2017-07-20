package solution600_699.solution625;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/18.
 */
public class Solution {
    public int smallestFactorization(int a) {
        if (a == 1) {
            return 1;
        }
        List<Integer> candidates = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                candidates.add(i);
                a /= i;
            }
        }
        if (a != 1) {
            return 0;
        }
        long res = 0;
        for (int i = candidates.size() - 1; i >= 0; i--) {
            res = res * 10 + candidates.get(i);
        }
        return res > Integer.MAX_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestFactorization(18000000));
    }
}
