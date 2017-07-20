package solution;

/**
 * Script Created by daidai on 2017/2/19.
 */
public class Solution028 {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        }
        if (l2 == 0) {
            return 0;
        }
        int delta = l1 - l2;
        for (int i = 0; i <= delta; i++) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution028 solution028 = new Solution028();
        System.out.println(solution028.strStr("aa", "aaa"));
    }
}
