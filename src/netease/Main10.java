package netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < m; i++) {
            dict.add(scanner.next());
        }

        int res = 0;
        Set<String> remember = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            if (dict.contains(word) && remember.add(word)) {
                res += word.length() * word.length();
            }
        }

        System.out.println(res);

    }

}
