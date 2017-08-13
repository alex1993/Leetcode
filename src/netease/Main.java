package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/12.
 */
public class Main {
    public static int dist(int n, int i, int[] xs, int[] ys, int x, int y) {
        int[] dist = new int[n];
        for (int k = 0; k < n; k++) {
            dist[k] = Math.abs(xs[k] - x) + Math.abs(ys[k] - y);
        }
        Arrays.sort(dist);
        int total = 0;
        for (int j = 0; j < i; j++) {
            total += dist[j];
        }
        return total;
    }

    public static int solve(int n, int i, int[] xs, int ys[]) {
        int res = Integer.MAX_VALUE;
        for (int x : xs) {
            for (int y : ys) {
                int total = dist(n, i, xs, ys, x, y);
                res = Math.min(res, total);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ys[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                System.out.print(" " + solve(n, i, xs, ys));
            } else {
                System.out.print(solve(n, i, xs, ys));
            }
        }
    }
}
