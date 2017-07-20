package solution000_099.solution022;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTracking(List<String> res, StringBuilder prefix, int leftCount, int rightCount, int n) {
        if (prefix.length() == 2 * n) {
            res.add(prefix.toString());
            return;
        }
        if (leftCount < n) {
            prefix.append('(');
            backTracking(res, prefix, leftCount + 1, rightCount, n);
            prefix.setLength(prefix.length() - 1);
        }
        if (rightCount < leftCount) {
            prefix.append(')');
            backTracking(res, prefix, leftCount, rightCount + 1, n);
            prefix.setLength(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(0));
    }
}
