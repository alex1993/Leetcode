package solution200_299.solution290;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/28.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        String[] strings = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (strings.length != pattern.length()) {
            return false;
        }

        Map<Character, String> toWord = new HashMap<>();
        Map<String, Character> toChar = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!toWord.containsKey(chars[i]) && !toChar.containsKey(strings[i])) {
                toWord.put(chars[i], strings[i]);
                toChar.put(strings[i], chars[i]);
            } else if (toWord.containsKey(chars[i]) && !toChar.containsKey(strings[i])) {
                return false;
            } else if (!toWord.containsKey(chars[i]) && toChar.containsKey(strings[i])) {
                return false;
            } else {
                if (!toWord.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
