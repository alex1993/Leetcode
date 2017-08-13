package solution100_199.solution151;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (i == words.length - 1) {
                sb.append(words[i]);
            } else {
                sb.append(" ").append(words[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("hi!"));
    }
}
