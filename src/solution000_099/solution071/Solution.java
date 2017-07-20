package solution000_099.solution071;

import java.util.Arrays;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/4/9.
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            if (!"".equals(s) && !".".equals(s) && !"..".equals(s)) {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
    }
}
