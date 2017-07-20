package solution400_499.solution461;

/**
 * Script Created by daidai on 2017/6/2.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return countOnes(x ^ y);
    }

    private int countOnes(int n) {
        if (n == 0) {
            return 0;
        }
        return countOnes(n / 2) + (n % 2 == 1 ? 1: 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
    }
}
