package solution100_199.solution150;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/6/21.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(operate(first, second, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int operate(Integer first, Integer second, String token) {
        switch (token) {
            case "+":
                return first + second;
            case "-":
                return second - first;
            case "*":
                return second * first;
            default:
                return second / first;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"4", }));
    }
}
