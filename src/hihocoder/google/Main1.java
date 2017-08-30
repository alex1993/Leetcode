package hihocoder.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/23.
 */
public class Main1 {

    private static int solve(String string) {
        List<String> list = fillChar(string);
        int maxValue = 0;
        for (String s : list) {
            String remove = removeDuplicate(s);
            int res = 0;
            while (remove.length() < s.length()) {
                res += s.length() - remove.length();
                s = remove;
                remove = removeDuplicate(remove);
            }
            maxValue = Math.max(maxValue, res);
        }
        return maxValue;
    }

    private static List<String> fillChar(String string) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < 3; j++) {
                char c = (char) ('A' + j);
                res.add(string.substring(0, i) + c + string.substring(i));
            }
        }
        return res;
    }

    private static String removeDuplicate(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) || i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(solve(scanner.next().trim()));
        }
    }
}
