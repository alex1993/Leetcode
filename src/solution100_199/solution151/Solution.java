package solution100_199.solution151;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/4/19.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i])) {
                continue;
            }
            if (first) {
                sb.append(strings[i]);
                first = false;
            } else {
                sb.append(" ").append(strings[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("   a   b "));
    }
}
