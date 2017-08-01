package solution300_399.solution387;

/**
 * Script Created by daidai on 2017/7/31.
 */
public class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[128];
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i]]++;
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (hash[c] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}
