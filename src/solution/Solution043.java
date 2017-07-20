package solution;

import java.math.BigInteger;

/**
 * Script Created by daidai on 2017/2/20.
 */
public class Solution043 {
    public String multiply(String num1, String num2) {
        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);
        return number1.multiply(number2) + "";
    }

    public String multi(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int po : pos) {
            if (!(stringBuilder.length() == 0 && po == 0)) {
                stringBuilder.append(po);
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution043 solution043 = new Solution043();
//        System.out.println(solution043.multiply("401716832807512840963",
//                "167141802233061013023557397451289113296441069"));
        System.out.println(solution043.multi("123", "456"));

    }
}
