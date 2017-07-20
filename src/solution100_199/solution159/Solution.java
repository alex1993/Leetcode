package solution100_199.solution159;

/**
 * Script Created by daidai on 2017/6/1.
 */
public class Solution {
    public int longestSubKDistinctChars(String s, int k) {
        int begin = 0, end = 0;
        int[] hash = new int[128];
        int counter = 0;
        int len = 0;
        while (end < s.length()) {
            if (hash[s.charAt(end)] == 0) {
                counter++;
            }
            hash[s.charAt(end)]++;
            end++;

            while (counter > k) {
                if (hash[s.charAt(begin)] == 0) {
                    counter--;
                }
                hash[s.charAt(begin)]--;
                begin++;
            }
            len = Math.max(len, end - begin);
        }
        return len;
    }
}
