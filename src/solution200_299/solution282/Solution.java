package solution200_299.solution282;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/21.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(res, "", num, 0, 0, 0, target);
        return res;
    }

    private void dfs(List<String> res, String prefix, String number, int pos, long eval, long mul, int target) {
        if (pos == number.length() && eval == target) {
            res.add(prefix);
        }
        for (int i = pos; i < number.length(); i++) {
            if (i != pos && number.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(number.substring(pos, i + 1));
            if (pos == 0) {
                dfs(res, prefix + cur, number, i + 1, cur, cur, target);
            } else {
                dfs(res, prefix + "+" + cur, number, i + 1, eval + cur, cur, target);
                dfs(res, prefix + "-" + cur, number, i + 1, eval - cur, -cur, target);
                dfs(res, prefix + "*" + cur, number, i + 1, eval - mul + mul * cur, mul * cur, target);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addOperators("105", 5));
    }
}
