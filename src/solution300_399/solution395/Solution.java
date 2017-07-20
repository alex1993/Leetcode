package solution300_399.solution395;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/2.
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int[][] lettersCount = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            System.arraycopy(lettersCount[i], 0, lettersCount[i + 1], 0, 26);
            lettersCount[i + 1][s.charAt(i) - 'a'] += 1;
        }

        int longest = 0;
        for (int start = 0; start < s.length(); start++) {
            if (longest >= s.length() - start) {
                return longest;
            }
            for (int end = s.length(); end > start; end--) {
                boolean works = true;
                for (int c = 0; c < 26; c++) {
                    int count = lettersCount[end][c] - lettersCount[start][c];
                    if (count < k && count != 0) {
                        works = false;
                        end = indexOf(s, start, (char) (c + 'a')) + 1;
                        break;
                    }
                }
                if (works) {
                    longest = Math.max(longest, end - start);
                    break;
                }
            }
        }
        return longest;
    }

    private int indexOf(String s, int start, char c) {
        char[] chars = s.toCharArray();
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public int solve(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }

        int n = s.length();
        int[] hash = new int[26];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.length() - i < max) {
                return max;
            }
            Arrays.fill(hash, 0);
            int count = 0;
            int check = 0;
            int end = 0;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                //用于统计不同字符的个数
                if (hash[index] == 0) {
                    count++;
                }
                //如果当前所有的字符都达到了 k 次以上，那么 check 最后的值可以达到 count * k
                if (hash[index] < k) {
                    check++;
                }
                hash[index] += 1;
                //合法的字符串
                if (check >= count * k) {
                    end = j;
                }
            }
            int nexMax = i == end ? 0 : end - i + 1;
            max = Math.max(nexMax, max);
        }
        return max;
    }

    private int divideConquer(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hash[c - 'a']++;
        }
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0 && hash[i] < k) {
                smallest = Math.min(smallest, hash[i]);
                index = i;
            }
        }
        if (smallest >= k) {
            return s.length();
        }

        String[] strings = s.split((Character.valueOf((char) ('a' + index))).toString());
        int max = 0;
        for (String str : strings) {
            max = Math.max(max, divideConquer(str, k));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divideConquer("aaabb", 3));
    }

}
