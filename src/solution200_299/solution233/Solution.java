package solution200_299.solution233;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Solution {
    public int countDigitOne(int n) {
        int ones = 0, m = 1, r = 1;
        while (n > 0) {
            ones += (n + 8) / 10 * m + (n % 10 == 1 ? r : 0);
            r += n % 10 * m;
            m *= 10;
            n /= 10;
        }
        return ones;
    }
}
