package solution600_699.solution633;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        for (int i = 0; i <= Math.sqrt(c); i++) {
            if (isSquare(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(int num) {
        long low = 0, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid < num) {
                low = mid + 1;
            } else if (mid * mid == num) {
                return true;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean newton(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(5));
        System.out.println(solution.judgeSquareSum(3));
        System.out.println(solution.judgeSquareSum(10));
        System.out.println(solution.judgeSquareSum(17));
        System.out.println(solution.judgeSquareSum(1));
        System.out.println(solution.judgeSquareSum(0));
        System.out.println(solution.judgeSquareSum(19));
    }

}
