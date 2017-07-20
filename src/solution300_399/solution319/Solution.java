package solution300_399.solution319;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        Arrays.fill(bulb, true);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j % i == i - 1) {
                    bulb[j] = !bulb[j];
                }
            }
        }

        int res = 0;
        for (boolean b : bulb) {
            if (b) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(4));
    }
}
