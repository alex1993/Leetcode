package solution300_399.solution394;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/1.
 */
public class Solution {
    public String decodeString(String s) {
        Stack<String> operand = new Stack<>();
        Stack<Integer> times = new Stack<>();
        char[] chars = s.toCharArray();
        return "";
    }

    private String dfs(String s, char[] chars, StringBuilder sb, int index) {
        if (Character.isDigit(chars[index])) {
            int parIndex = s.indexOf(index + 1, '[');
            int num = Integer.parseInt(s.substring(index, parIndex));
            String sub = dfs(s, chars, sb, parIndex + 1);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < num; i++) {
                res.append(sub);
            }
            return res.toString();
        } else {
            return "";
        }
    }
}