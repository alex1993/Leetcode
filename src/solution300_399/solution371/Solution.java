package solution300_399.solution371;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getSum(a ^ b, (a & b) << 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, -100));
    }

}
