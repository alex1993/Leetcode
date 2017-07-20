package solution100_199.solution131;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/3/23.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), 0, s);
        return res;
    }

    private void backTracking(List<List<String>> res, List<String> prefix, int level, String s) {
        if (level == s.length()) {
            res.add(new ArrayList<>(prefix));
        }
        for (int i = level; i < s.length(); i++) {
            if (isPalinDrome(s, level, i)) {
                prefix.add(s.substring(level, i + 1));
                backTracking(res, prefix, i + 1, s);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    private boolean isPalinDrome(String s, int level, int i) {
        while (level < i) {
            if (s.charAt(level) != s.charAt(i)) {
                return false;
            }
            level++;
            i--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
    }
}
