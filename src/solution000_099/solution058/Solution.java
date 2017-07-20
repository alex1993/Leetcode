package solution000_099.solution058;

/**
 * Script Created by daidai on 2017/5/25.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        boolean first = true;
        int next = 0;
        int prev = 0;
        int i = chars.length - 1;
        while (i >= 0 && chars[i] == ' ') {
            i--;
        }
        next = i;
        while (i >= 0 && chars[i] != ' ') {
            i--;
        }
        prev = i;
        return next - prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("World"));
    }
}