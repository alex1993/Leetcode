package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/12.
 */
public class MainToday1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(" ");
        int x = Integer.parseInt(split[0]);
        int f = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);
        int p = Integer.parseInt(split[3]);
        int res = Integer.MIN_VALUE;
        int low = 0, high = d / p;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int apple = f + mid;
            int room = (d - p * mid) / x;
            res = Math.max(res, Math.min(apple, room));
            if (apple < room) {
                low = mid + 1;
            } else if (apple > room) {
                high = mid - 1;
            } else {
                System.out.println(res);
                return;
            }
        }

//        for (int i = 0; i <= d / p; i++) {
//            int apple = f + i;
//            int room = (d - p * i) / x;
//            res = Math.max(res, Math.min(apple, room));
//        }
        System.out.println(res);

    }
}
