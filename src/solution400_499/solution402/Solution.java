package solution400_499.solution402;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/20.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> s = new Stack<>();
        int j = k;
        for (char c : num.toCharArray()) {
            int val = c - '0';
            while (!s.isEmpty() && s.peek() > val && k > 0) {
                s.pop();
                k--;
            }
            s.push(val);
        }
        while (s.size() > num.length() - j) {
            s.pop();
        }
        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty())
            sb.append(s.pop());
        String res = sb.reverse().toString();
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') return res.substring(i);
        }
        return "0";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("112", 1));
    }
}
