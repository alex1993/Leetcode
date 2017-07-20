package solution000_099.solution087;

/**
 * Script Created by daidai on 2017/6/9.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] hash = new int[26];
        char[] chars1 = s1.toCharArray();
        for (char c : chars1) {
            hash[c - 'a']++;
        }
        char[] chars2 = s2.toCharArray();
        for (char c : chars2) {
            hash[c - 'a']--;
        }
        for (int i : hash) {
            if (i != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length())))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()))
                    && isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isScramble("great", "rgeat"));

    }
}
