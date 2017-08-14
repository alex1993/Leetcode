package solution100_199.solution168;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(10));
        System.out.println(solution.convertToTitle(20));
        System.out.println(solution.convertToTitle(30));
    }
}
