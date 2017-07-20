package solution100_199.solution171;

/**
 * Script Created by daidai on 2017/4/16.
 */
public class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            num = num * 26 + c - ('A' - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("C"));
        System.out.println(solution.titleToNumber("Z"));
        System.out.println(solution.titleToNumber("ZZ"));
        System.out.println(solution.titleToNumber("AA"));
    }
}
