package solution500_599.solution507;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (num / i != i) {
                    sum += num / i;
                }
            }
        }
        sum += 1;
        return sum == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPerfectNumber(1));
    }
}
