package solution400_499.solution455;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/28.
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(new int[]{}, new int[]{}));
    }
}
