package solution300_399.solution331;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/6/1.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String string : strings) {
            //当前字符是 #，并且栈顶也是 #，表示可以将当前两个节点合并，成为一个新的叶子节点
            while (string.equals("#") && (!stack.isEmpty() && stack.peek().equals("#"))) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(string);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization("1,#,#,#,#"));
    }
}
