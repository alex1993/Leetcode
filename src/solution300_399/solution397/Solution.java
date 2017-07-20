package solution300_399.solution397;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public int integerReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 1) {
            return Math.min(1 + integerReplacement(n - 1), 1 + integerReplacement(n + 1));
        } else {
            return 1 + integerReplacement(n / 2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerReplacement(2147483647));
    }
}
