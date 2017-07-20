package solution300_399.solution367;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }
        long low = 0, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid > num) {
                high = mid - 1;
            } else if (mid * mid == num) {
                return true;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean newton(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(2));
        System.out.println(solution.isPerfectSquare(3));
        System.out.println(solution.isPerfectSquare(4));
        System.out.println(solution.newton(9));
    }
}
