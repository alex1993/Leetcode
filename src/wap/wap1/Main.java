package wap.wap1;

import java.util.Scanner;

public class Main {

    public static long mod = 100003;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long m = in.nextInt();
        long n = in.nextInt();
        System.out.println(solve(m, n));
    }

    public static long solve(long m, long n) {
        return (mod + myPow(m, n) - m * myPow(m - 1, n - 1) % mod) % mod;
    }


    public static long myPow(long x, long n) {
        x %= mod;
        if (n == 0) {
            return 1;
        }
        long r = myPow(x, n / 2);
        r = r * r % mod;
        if (n % 2 == 0) {
            return r;
        } else {
            return (x * r) % mod;
        }

    }

}
