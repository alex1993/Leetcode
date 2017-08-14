package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/12.
 */
public class MainToday3 {


    public static int mod = 1000000007;

    public static int solve(int n, int k) {
        //dp[i] 表示最大的数为 k，长度为 n 的数列个数，默认情况，全部数字都
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int[] nextDp = new int[k + 1];
            for (int next = 1; next <= k; next++) {
                for (int tail = 1; tail <= k; tail++) {
                    if (next >= tail || tail % next != 0) {
                        nextDp[next] = nextDp[next] + dp[tail];
                        nextDp[next] %= mod;
                    }
                }
            }
            dp = nextDp;
        }

        int res = 0;
        for (int num : dp) {
            res = (res + num) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }
}
