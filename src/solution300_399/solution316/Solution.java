package solution300_399.solution316;

import java.util.*;

/**
 * Script Created by daidai on 2017/7/18.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.putIfAbsent(chars[i], new LinkedList<>());
            map.get(chars[i]).add(i);
        }

        //set用来保存当前string中已有的字符
        Set<Character> set = new HashSet<>();
        //stack用来保存当前的结果
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //当前字符比栈顶要更小，并且在这个栈之前没有出现过
            while (!stack.isEmpty() && stack.peek() >= c && !set.contains(c)) {
                Character prev = stack.peek();
                if (!map.get(prev).isEmpty()) {
                    stack.pop();
                    set.remove(prev);
                } else {
                    break;
                }
            }
            if (!set.contains(c)) {
                stack.push(c);
                set.add(c);
            }
            map.get(c).poll();
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}
