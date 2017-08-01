package solution300_399.solution344;

/**
 * Script Created by daidai on 2017/7/20.
 */
public class Solution {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("test"));
    }
}
