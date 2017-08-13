package solution000_099.solution017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");
        List<String> res = new ArrayList<>();
        backTracking(res, new StringBuilder(), digits, 0, map);
        return res;
    }

    private void backTracking(List<String> res, StringBuilder prefix, String digits, int level, Map<Character, String> map) {
        if (prefix.length() == digits.length()) {
            res.add(prefix.toString());
            return;
        }
        String alphas = map.get(digits.charAt(level));
        for (char c : alphas.toCharArray()) {
            prefix.append(c);
            backTracking(res, prefix, digits, level + 1, map);
            prefix.setLength(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
