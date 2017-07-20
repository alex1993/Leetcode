package solution100_199.solution172;

/**
 * Script Created by daidai on 2017/7/4.
 */
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(25));
    }
}
