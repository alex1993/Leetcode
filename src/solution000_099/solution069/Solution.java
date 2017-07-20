package solution000_099.solution069;

/**
 * Script Created by daidai on 2017/5/27.
 */
public class Solution {
    public long mySqrt(long x) {
        if (x == 0) {
            return 0;
        }
        long low = 0, high = x;
        while (true) {
            long mid = low + (high - low) / 2;
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                low = mid + 1;
            }
        }
    }

    public int newton(long x) {
        if (x == 0) {
            return 0;
        }
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.mySqrt(1000));
        System.out.println(solution.newton(2147395599));
        System.out.println(solution.mySqrt(2147395599));
    }
}
