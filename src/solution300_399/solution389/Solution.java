package solution300_399.solution389;

/**
 * Script Created by daidai on 2017/6/9.
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int res = 0;
        for (char c : chars1) {
            res ^= c;
        }
        for (char c : chars2) {
            res ^= c;
        }
        return (char) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abced"));
    }
}
