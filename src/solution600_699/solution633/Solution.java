package solution600_699.solution633;

/**
 * Script Created by daidai on 2017/7/2.
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
        if (num == 0) {return true;}
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
