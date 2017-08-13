package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        String[] strings = new String[row];
        for (int i = 0; i < row; i++) {
            strings[i] = scanner.next();
        }

        int res = 0;
        for (int j = 0; j < strings[0].length(); j++) {
            int count = 1;
            for (int i = 0; i < strings.length; i++) {
                if (i < strings.length - 1 && strings[i].charAt(j) == strings[i + 1].charAt(j)) {
                    count++;
                    res = Math.max(res, count);
                } else {
                    count = 1;
                }
            }
        }

        System.out.println(res);
    }
}
