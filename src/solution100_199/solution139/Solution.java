package solution100_199.solution139;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Script Created by daidai on 2017/6/7.
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new TreeSet<>((s1, s2) -> s1.length() - s2.length());
        dict.addAll(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsdog", new ArrayList<String>() {{
            add("cats");
            add("dog");
        }}));
    }
}