package solution300_399.solution394;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/1.
 */
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = 10 * num + (chars[i] - '0');
                    i++;
                }
                nums.push(num);
                i--;
            } else if (chars[i] == '[') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && Character.isAlphabetic(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
                strings.push(sb.toString());
                i--;
            } else if (chars[i] == ']') {
                String str = strings.pop();
                Integer count = nums.pop();
                StringBuilder sb = new StringBuilder();
                for (Integer index = 0; index < count; index++) {
                    sb.append(str);
                }
                strings.push((strings.isEmpty() ? "" : strings.pop()) + sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && Character.isAlphabetic(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
                strings.push((strings.isEmpty() ? "": strings.pop()) + sb.toString());
                i--;
            }
        }
        return strings.isEmpty() ? "" : strings.pop();
    }

    private String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                //find matching []
                int begin = ++i;
                int count = 1;
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;
                String sub = solve(s.substring(begin, i));
                for (int j = 0; j < num; j++) {
                    sb.append(sub);
                }
                num = 0;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("gh2[a1[ef]bc]3[cd]ef"));
        System.out.println(solution.solve("gh2[a1[ef]bc]3[cd]ef"));
    }
}