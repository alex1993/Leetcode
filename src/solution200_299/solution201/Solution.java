package solution200_299.solution201;

/**
 * Script Created by daidai on 2017/6/23.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int factor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m * factor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(15, 17));
    }
}
