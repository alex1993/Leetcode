package solution000_099.solution066;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int[] res = new int[digits.length];
        int n = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i] + carry + n;
            n = 0;
            res[i] = cur % 10;
            carry = cur / 10;
        }
        if (carry == 1) {
            int[] fin = new int[res.length + 1];
            System.arraycopy(res, 0, fin, 1, fin.length - 1);
            fin[0] = 1;
            return fin;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }
}
