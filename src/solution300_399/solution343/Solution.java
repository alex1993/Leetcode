package solution300_399.solution343;

/**
 * Script Created by daidai on 2017/6/10.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(4));
        System.out.println(solution.integerBreak(6));
        System.out.println(solution.integerBreak(10));
        System.out.println(solution.integerBreak(6));
    }
}
