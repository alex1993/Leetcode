package solution300_399.solution365;

/**
 * Script Created by daidai on 2017/8/14.
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canMeasureWater(0, 0, 0));
        System.out.println(solution.canMeasureWater(34, 5, 6));
    }
}
