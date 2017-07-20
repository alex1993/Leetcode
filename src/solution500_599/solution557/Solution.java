package solution500_599.solution557;

/**
 * Script Created by daidai on 2017/4/9.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        String[] tmp = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(strings[i]);
            stringBuilder.reverse();
            tmp[i] = stringBuilder.toString();
        }
        return String.join(" ", tmp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
