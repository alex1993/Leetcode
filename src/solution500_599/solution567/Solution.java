package solution500_599.solution567;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/30.
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int begin = 0, end = 0;
        int[] hash = new int[128];
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            hash[c]++;
        }

        int counter = s1.length();
        while (end < s2.length()) {
            if (hash[s2.charAt(end)] > 0) {
                counter--;
            }
            hash[s2.charAt(end)]--;
            end++;

            while (counter == 0) {
                if (end - begin == s1.length()) {
                    return true;
                }
                if (hash[s2.charAt(begin)] >= 0) {
                    counter++;
                }
                hash[s2.charAt(begin)]++;
                begin++;
            }
        }

        return false;
    }

    private List<String> permutation(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s, new StringBuilder(), res, 0, new boolean[s.length()]);
        return res;
    }

    private void backTracking(String s, StringBuilder sb, List<String> res, int level, boolean[] used) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            sb.append(s.charAt(i));
            used[i] = true;
            backTracking(s, sb, res, level + 1, used);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "ediboaaa"));
        List<String> res = solution.permutation("abc");
        System.out.println(res);
        System.out.println(new HashSet<>(res));
    }
}
