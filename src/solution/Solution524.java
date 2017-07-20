package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/26.
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        List<String> result = new ArrayList<>();
        for (String r : d) {
            if (delete(s, r)) {
                result.add(r);
            }
        }
        result.sort((s1, s2) -> {
            if (s1.length() < s2.length()) {
                return 1;
            } else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return -1;
            }
        });
        return result.size() > 0 ? result.get(0) : "";
    }

    private boolean delete(String s, String r) {
        int sLen = s.length();
        int rLen = r.length();
        int i = 0, j = 0;
        while (i < sLen && j < rLen) {
            if (s.charAt(i) == r.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == rLen;
    }

    public static void main(String[] args) {
        Solution524 solution524 = new Solution524();
        String s = "abpcplea";
        List<String> test = new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println(solution524.findLongestWord(s, test));
    }
}
