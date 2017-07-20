package solution000_099.solution093;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/10.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backTracking(s, res, new StringBuilder(), 0, 0);
        return res;
    }

    private void backTracking(String s, List<String> res, StringBuilder sb, int pos, int count) {
        if (pos == s.length() && count == 3) {
            res.add(sb.toString());
            return;
        }
        if (count > 3) {
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos, i + 1);
            if (sub.length() > 3 || sub.length() > 1 && sub.charAt(0) == '0' || Integer.valueOf(sub) > 255) {
                break;
            }

            int len = sb.length();

            sb.append(sub);
            if (i != s.length() - 1) {
                sb.append(".");
                backTracking(s, res, sb, i + 1, count + 1);
            } else {
                backTracking(s, res, sb, i + 1, count);
            }

            sb.setLength(len);
        }

    }

    private List<String> solve(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }

                }
            }
        }
        return res;
    }

    private boolean isValid(String sub) {
        return !(sub.length() > 3 || sub.length() > 1 && sub.charAt(0) == '0' || Integer.parseInt(sub) > 255);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("25525511135"));
    }
}
