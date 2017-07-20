package solution400_499.solution438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Script Created by daidai on 2017/5/31.
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new ArrayList<>();
        }
        //two pointers
        int begin = 0, end = 0;
        int[] hash = new int[128];
        char[] chars = p.toCharArray();
        for (char c : chars) {
            hash[c]++;
        }

        List<Integer> res = new ArrayList<>();
        //使用count来标识当前 s 的子串是否覆盖了 p
        int count = p.length();
        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                count--;
            }
            hash[s.charAt(end)]--;
            end++;

            //当 count 为 0 时，移动左指针
            while (count == 0) {
                if (end - begin == p.length()) {
                    res.add(begin);
                }
                //当 hash 值过头了……表示当前字符串包含的 字符 太多了，跳出当前循环
                if (hash[s.charAt(begin)] >= 0) {
                    count++;
                }
                //恢复 hash 值
                hash[s.charAt(begin)]++;
                begin++;
            }
        }

        return res;
    }

    public List<Integer> solve(String s, String t) {
        int begin = 0, end = 0;
        int[] hash = new int[128];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        List<Integer> res = new ArrayList<>();
        int counter = t.length();
        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                counter--;
            }
            hash[s.charAt(end)]--;
            end++;

            if (counter == 0) {
                res.add(begin);
            }
            //if we find the window's size equals to t, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (end - begin == t.length() ) {
                if (hash[s.charAt(begin)] >= 0) {
                    counter++;
                }
                hash[s.charAt(begin)]++;
                begin++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
