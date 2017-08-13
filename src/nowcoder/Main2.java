package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Main2 {

    private static int count(String string) {
        int res = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        set.add('A');
        set.add('C');
        set.add('G');
        set.add('T');
        for (int i = 0; i < string.length(); i++) {
            if (set.contains(string.charAt(i))) {
                count++;
                res = Math.max(count, res);
            } else {
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(count(scanner.next()));
    }
}
