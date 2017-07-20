package solution600_699.solution640;

import java.util.Arrays;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/9.
 */
public class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];

        Integer[] leftInt = countXNumber(left);
        Integer[] rightInt = countXNumber(right);

        int xCount = leftInt[0] - rightInt[0];
        int numCount = rightInt[1] - leftInt[1];
        if (xCount == 0 && numCount != 0) {
            return "No solution";
        }
        if (xCount == 0) {
            return "Infinite solutions";
        }
        return "x=" + numCount / xCount;
    }

    private Integer[] countXNumber(String string) {
        Integer[] res = new Integer[2];
        char[] chars = string.toCharArray();
        Stack<Integer> xStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int x = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int cur = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    cur = cur * 10 + (chars[i] - '0');
                    i++;
                }
                if (isX(i, chars)) {
                    x += sign * cur;
                } else {
                    num += sign * cur;
                }
                i--;
            } else if (chars[i] == '+') {
                sign = 1;
            } else if (chars[i] == '-') {
                sign = -1;
            } else {
                if (i == 0 || !Character.isDigit(chars[i - 1])) {
                    x += sign;
                }
            }
        }
        return new Integer[]{x, num};
    }

    private boolean isX(int i, char[] chars) {
        return i < chars.length && chars[i] == 'x';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solution.solveEquation("x=x"));
        System.out.println(solution.solveEquation("x=x+2"));
        System.out.println(solution.solveEquation("2x+3x-6x=x+2"));
        System.out.println(solution.solveEquation("2x=x"));
    }
}
