package nowcoder;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Main1 {

    public static int replace(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                res++;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(replace(string));
    }
}
