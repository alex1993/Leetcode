package solution300_399.solution392;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int[] j = new int[]{0};
        for (char c : s.toCharArray()) {
            if(!find(t, j, c)) {
                return false;
            }
        }
        return true;
    }

    private boolean find(String t, int[] start, char c) {
        while (start[0] < t.length()) {
            if (t.charAt(start[0]) == c) {
                start[0]++;
                return true;
            }
            start[0]++;
        }
        return false;
    }

    private boolean solve(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve("abc", "ahbgdc"));
        System.out.println(solution.solve("acb", ""));
    }
}
