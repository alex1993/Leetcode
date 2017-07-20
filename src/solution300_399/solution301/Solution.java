package solution300_399.solution301;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int lastI, int lastJ, char[] par) {
        for (int stack = 0, i = lastI; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = lastJ; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            // finished right to left
            ans.add(reversed);
        }
    }

    private List<String> solve(String string) {
        List<String> res = new ArrayList<>();
        if (string == null) {
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(string);
        visited.add(string);

        boolean found = false;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                found = true;
            }
            if (found) {
                continue;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                String t = s.substring(0, i) + s.substring(i + 1, s.length());
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }

        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("("));
    }
}
