package netease.sol2;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        int boyNum = 0;
        int boySum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G') {
                boyNum++;
                boySum += i;
            }
        }
        int front = 0;
        int after = 0;
        for (int i = 0; i < boyNum; i++) {
            front += i;
            after += (chars.length - 1 - i);
        }
        int min = Math.abs(boySum - front) < Math.abs(boySum - after) ? Math.abs(boySum - front) : Math.abs(boySum - after);
        System.out.println(min);
    }

}
