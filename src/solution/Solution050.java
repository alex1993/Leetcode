package solution;

/**
 * Script Created by daidai on 2017/2/21.
 */
public class Solution050 {
    @SuppressWarnings("not right")
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

//    nest pow
    public double myPow2(double x, int n) {
        if (n < 0) {
            return 1 / x * myPow2(1 / x, -(n + 1));
        }
        if (n == 0) {
            return 1;
        }
        if (n == 2) {
            return x * x;
        }
        if (n % 2 == 0) {
            return myPow2(x * x, n / 2);
        } else {
            return x * myPow2(x * x, n / 2);
        }

    }

//    double myPow
    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double t = myPow3(x, n / 2);
        if (n % 2 == 0) {
            return t * t;
        } else {
            return n > 0 ? x * t * t : 1 / x * t * t;
        }
    }

    @SuppressWarnings("not right")
    public double myPow4(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution050 solution050 = new Solution050();
        System.out.println(solution050.myPow4(2.00000, -2147483648));
    }
}
