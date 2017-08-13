package netease;

import java.util.*;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main6 {

    private static int res = 0;

    private static void backTracking(String[] ables, int index, HashSet<Integer> set) {
        if (index == ables.length) {
            res++;
            return;
        }
        String able = ables[index];
        for (int i = 0; i < able.length(); i++) {
            int c = able.charAt(i) - '0';
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            backTracking(ables, index + 1, set);
            set.remove(c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] ables = new String[count];
        for (int i = 0; i < count; i++) {
            ables[i] = scanner.next();
        }
        backTracking(ables, 0, new HashSet<>());
        System.out.println(res);
    }

}
