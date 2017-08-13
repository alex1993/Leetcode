package solution000_099.solution050;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return (1.0 / x) * myPow(1.0 / x, -(n + 1));
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 3));
        System.out.println(solution.myPow(2, 0));
        System.out.println(solution.myPow(2, 1));
        System.out.println(solution.myPow(2, -1));
        System.out.println(solution.myPow(1, -1));
        System.out.println(solution.myPow(1, Integer.MIN_VALUE));
    }
}
