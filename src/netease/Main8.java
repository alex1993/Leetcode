package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main8 {

    private static int calculate(String s) {
        int num = 0;
        char op = '+';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (op == '+') {
                    res += num;
                }
                if (op == '-') {
                    res -= num;
                }
                if (op == '*') {
                    res *= num;
                }
                num = 0;
                i--;
            } else if (s.charAt(i) == '+') {
                op = '+';
            } else if (s.charAt(i) == '-') {
                op = '-';
            } else if (s.charAt(i) == '*') {
                op = '*';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(calculate(string));
    }
}
