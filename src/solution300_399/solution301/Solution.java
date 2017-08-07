package solution300_399.solution301;

import java.util.List;

/**
 * Script Created by daidai on 2017/8/4.
 */
public class Solution {
    //fixme
    public List<String> removeInvalidParentheses(String s) {
        return null;
    }

    //先从左往右扫，去除多余的右括号，然后再从右往左扫，去除多余的左括号
    //如果有多个都可去除的括号，约定去除第一个出现的，例如 ())，去除s[1]
    //但是有可能有多种组合结果，所以还需要记录上次删除的位置，下一次从该位置出发，可以避免产生重复的结果
    //例如 (()))),应当去除 s[2]s[3]
    private void remove(List<String> res, String s, int left, int right, char[] pair) {
        int counter = 0;
        for (int i = left; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                counter++;
            }
            if (s.charAt(i) == pair[1]) {
                counter--;
            }
            //始终匹配，那么继续
            if (counter >= 0) {
                continue;
            }
            for (int j = right; j < s.length(); j++) {
                if (s.charAt(j) == pair[1] && (j == right || s.charAt(j - 1) != pair[1])) {
//                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), s, );
                }
            }
        }
    }
}
