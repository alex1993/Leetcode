package solution;

/**
 * Script Created by daidai on 2017/2/19.
 */
public class Solution029 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int res = 0;

        while (dvd >= dvs) {
            long tmpDvs = dvs;
            int multi = 1;
            while (dvd >= (tmpDvs << 1)) {
                tmpDvs <<= 1;
                multi <<= 1;
            }
            dvd -= tmpDvs;
            res += multi;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        Solution029 solution029 = new Solution029();
        System.out.println(solution029.divide(1, 1));
    }
}
