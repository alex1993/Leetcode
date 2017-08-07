package solution000_099.solution003;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        int len = 0;
        int[] hash = new int[128];
        int counter = 0;
        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                counter++;
            }
            hash[s.charAt(end)]++;
            end++;
            while (counter > 0) {
                if (hash[s.charAt(begin)] > 1) {
                    counter--;
                }
                hash[s.charAt(begin)]--;
                begin++;
            }
            len = Math.max(end - begin, len);
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcdcef"));
    }
}
