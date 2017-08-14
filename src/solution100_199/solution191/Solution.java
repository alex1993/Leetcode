package solution100_199.solution191;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n -= (n & -n);
        }
        return count;
    }

    public int solve(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (1 << i & n) != 0 ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-4));
    }
}
