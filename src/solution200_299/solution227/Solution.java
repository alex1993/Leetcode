package solution200_299.solution227;

/**
 * Script Created by daidai on 2017/5/15.
 */
public class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim().replace(" ", "");

        int res = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        char sign = '+';
        int prev = 0;
        while (i < chars.length) {
            int cur = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                cur = cur * 10 + chars[i] - '0';
                i++;
            }

            if (sign == '+') {
                res += prev;
                prev = cur;
            } else if (sign == '-') {
                res += prev;
                prev = -cur;
            } else if (sign == '*') {
                prev *= cur;
            } else if (sign == '/') {
                prev /= cur;
            }

            if (i < chars.length) {
                sign = chars[i];
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
