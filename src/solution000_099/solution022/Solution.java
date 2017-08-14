package solution000_099.solution022;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTracking(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backTracking(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backTracking(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(6));
    }
}
