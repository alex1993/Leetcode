package netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] seq = new int[num];

        Stack<Integer> tmpStack = new Stack<>();
        for (int i = 0; i < num; i++) {
             seq[i] = scanner.nextInt();
             tmpStack.push(seq[i]);
        }

        Stack<Integer> resStack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        while (!tmpStack.isEmpty()) {
            int cur = tmpStack.pop();
            if (set.add(cur)) {
                resStack.push(cur);
            }
        }

        System.out.print(resStack.pop());
        while (!resStack.isEmpty()) {
            System.out.print(" " + resStack.pop());
        }
    }
}
