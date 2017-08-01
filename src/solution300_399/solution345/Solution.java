package solution300_399.solution345;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/29.
 */
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chars = s.toCharArray().clone();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!set.contains(chars[i])) {
                i++;
                continue;
            }
            if (!set.contains(chars[j])) {
                j--;
                continue;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("aA"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
