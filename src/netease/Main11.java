package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main11 {

    static void tower(int[] bricks, int[][] h, int n, int sum) {
        h[0][0] = 0;
        for (int i = 1; i <= sum; i++) {
            h[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            int b = bricks[i - 1];
            for (int j = 0; j <= sum; j++) {
                h[i][j] = h[i - 1][j];
                if (j + b <= sum) {
                    h[i][j] = Math.max(h[i][j], h[i - 1][j + b] + b);
                }
                if (b - j >= 0) {
                    h[i][j] = Math.max(h[i][j], h[i - 1][b - j] + b - j);
                } else {
                    h[i][j] = Math.max(h[i][j], h[i - 1][j - b]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bricks = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            bricks[i] = sc.nextInt();
            sum = sum + bricks[i];
        }
        int[][] h = new int[n + 1][sum + 1];
        tower(bricks, h, n, sum);
        System.out.println(h[n][0] > 0 ? h[n][0] : -1);
    }
}
