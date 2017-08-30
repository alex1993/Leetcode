package hihocoder.week164;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String string = scanner.next().trim();
            int res = dp(string);
            System.out.println(res);
        }
    }

    private static int minStep(String string) {
        int tmp = count(string, '0');
        int res = tmp;
        for (int j = 0; j < string.length(); ++j) {
            if (string.charAt(j) == '0') {
                --tmp;
                if (res > tmp) {
                    res = tmp;
                }
            } else {
                ++tmp;
            }
        }
        return res;
    }

    private static int count(String string, char c) {
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                res++;
            }
        }
        return res;
    }

    private static int dp(String string) {
        int n = string.length();
        int[][] dp = new int[n][2];
        if (string.charAt(0) == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (string.charAt(i) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]);
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
