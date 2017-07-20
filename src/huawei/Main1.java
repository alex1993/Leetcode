package huawei;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Main1 {

    public static void main(String[] args) {
        int alpha = 0;
        int digit = 0;
        int others = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (isDigit(chars[i])) {
                    digit++;
                    while (i + 1 < chars.length && isDigit(chars[i + 1])) {
                        i++;
                    }
                } else if (isAlpha(chars[i])) {
                    alpha++;
                    while (i + 1 < chars.length && isAlpha(chars[i + 1])) {
                        i++;
                    }
                } else {
                    others++;
                    while (i + 1 < chars.length && (!isAlpha(chars[i + 1]) && !isDigit(chars[i + 1]))) {
                        i++;
                    }
                }
            }
            System.out.println(alpha + "," + digit + "," + others);

        }
    }

    private static boolean isDigit(char c) {
        return '0' <= c && '9' >= c;
    }

    private static boolean isAlpha(char c) {
        return ('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c);
    }
}
