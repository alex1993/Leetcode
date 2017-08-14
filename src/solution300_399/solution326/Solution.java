package solution300_399.solution326;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(3));
        System.out.println(solution.isPowerOfThree(6));
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(0));
    }
}
