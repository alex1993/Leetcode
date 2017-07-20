package solution300_399.solution306;

import java.math.BigInteger;

/**
 * Script Created by daidai on 2017/7/15.
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(x1, x2, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) {
            return true;
        }
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }


    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 0) {
            return false;
        }
        if (num.charAt(i) == '0' && j > 0) {
            return false;
        }
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("198019823962"));
    }
}
