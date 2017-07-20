package ms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/4/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> dig = new HashMap<>();
        Map<Integer, Integer> rev = new HashMap<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
            if (row.containsKey(x)) {
                c1 = row.get(x);
            }
            if (col.containsKey(y)) {
                c2 = col.get(y);
            }
            if (dig.containsKey(x -y )) {
                c3 = dig.get(x - y);
            }
            if (rev.containsKey(x + y)) {
                c4 = rev.get(x + y);
            }
            result += (c1 + c2 + c3 + c4);
            row.put(x, c1 + 1);
            col.put(y, c2 + 1);
            dig.put(x - y, c3 + 1);
            rev.put(x + y, c4 + 1);
        }
        System.out.println(result);
    }
}

