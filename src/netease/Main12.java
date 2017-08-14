package netease;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        long[][] dp = new long[str.length() + 1][]; //不用long的话通过率只能为90%
        for (int i = 0; i <= str.length(); i++) {
            dp[i] = new long[n];
        }

        dp[0][0] = 1;

        for (int i = 1; i <= str.length(); i++) {
            char c = str.charAt(i - 1);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 10; k++) {
                    if (c == 'X' || c == '0' + k) {
                        dp[i][(j * 10 + k) % n] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[str.length()][0]);

    }
}