package solution100_199.solution168;

/**
 * Script Created by daidai on 2017/4/16.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(3));
        System.out.println(solution.convertToTitle(26));
        System.out.println(solution.convertToTitle(28));
    }
}
