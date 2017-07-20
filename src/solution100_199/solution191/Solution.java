package solution100_199.solution191;

/**
 * Script Created by daidai on 2017/7/4.
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(3));
        System.out.println(solution.hammingWeight(1));
        System.out.println(solution.hammingWeight(-1));
        System.out.println(solution.hammingWeight(15));
    }
}
