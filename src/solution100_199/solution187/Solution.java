package solution100_199.solution187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/4.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        int[] hash = new int[26];
        hash[0] = 0;
        hash['C' - 'A'] = 1;
        hash['G' - 'A'] = 2;
        hash['T' - 'A'] = 3;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 9; i++) {
            //将字符编码为数字
            int val = 0;
            for (int j = 0; j < 10; j++) {
                val <<= 2;
                val |= hash[chars[i + j] - 'A'];
            }
            //当前数字已经在 words 里出现，但是 doubleWords 还没有，即第二次出现时，添加到结果中
            if (words.contains(val) && !doubleWords.contains(val)) {
                res.add(s.substring(i, i + 10));
                doubleWords.add(val);
            }
            words.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAAAAAA"));
    }
}
