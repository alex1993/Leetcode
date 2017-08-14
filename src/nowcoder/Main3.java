package nowcoder;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Main3 {

    private static int removeDouble(String string) {
        for (int i = string.length() - 3; i > 0; i-=2) {
            if (isDouble(string, 0, i)) {
                return i + 1;
            }
        }
        return 0;
    }

    private static boolean isDouble(String s, int start, int end) {
        int mid = (start + end + 1) / 2;
        while (mid <= end) {
            if (s.charAt(start) != s.charAt(mid)) {
                return false;
            }
            start++;
            mid++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(removeDouble(scanner.next()));
    }
}
