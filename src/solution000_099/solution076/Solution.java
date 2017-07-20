package solution000_099.solution076;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Script Created by daidai on 2017/5/31.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int begin = 0, end = 0, d = Integer.MAX_VALUE;
        int head = 0;
        int[] hash = new int[128];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        //counter to see if cur sub string valid
        int counter = t.length();
        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                counter--;
            }
            hash[s.charAt(end)]--;
            end++;

            // find a sub string
            while (counter == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                //make hash value valid again
                if (hash[s.charAt(begin)] == 0) {
                    counter++;
                }
                hash[s.charAt(begin)]++;
                begin++;
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
