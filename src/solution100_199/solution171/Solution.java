package solution100_199.solution171;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("AA"));
        System.out.println(solution.titleToNumber("AD"));
        System.out.println(solution.titleToNumber("Z"));
    }
}
