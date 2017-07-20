package solution300_399.solution342;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        //有且只有一位是 1，并且这一位处于基数位
        return (num & (num - 1)) == 0  && (num & 0x55555555) != 0;
    }
}
