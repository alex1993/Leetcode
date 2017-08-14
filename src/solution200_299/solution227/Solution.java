package solution200_299.solution227;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim().replace(" ", "");

        int res = 0;
        int i = 0;
        char sign = '+';
        int prev = 0;
        while (i < s.length()) {
            int num = 0;
            if (s.charAt(i) == ' ') {
                continue;
            }
            while (Character.isDigit(num)) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (sign == '+') {
                res += prev;
                prev = num;
            } else if (sign == '-') {
                res += prev;
                prev = -num;
            } else if (sign == '*') {
                res *= prev;
            } else {
                res /= prev;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
            }
            i++;
        }

        res += prev;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3 + 2 * 2"));
    }
}
