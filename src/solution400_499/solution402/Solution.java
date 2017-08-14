package solution400_499.solution402;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > cur && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer ele : stack) {
            sb.append(ele);
        }
        String res = sb.length() == 0 ? "0" : sb.toString();
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                return res.substring(i);
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("112", 1));
        System.out.println(solution.removeKdigits("10200", 1));
    }
}
