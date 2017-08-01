package solution000_099.solution014;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = intersect(res, strs[i]);
        }
        return res;
    }

    private String intersect(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }
        return str1.substring(0, i);
    }
}
