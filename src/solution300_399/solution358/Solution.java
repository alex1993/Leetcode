package solution300_399.solution358;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/19.
 */
public class Solution {
    public String rearrangeString(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<CharCount> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new CharCount(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int dist = k;
            List<CharCount> tmpList = new ArrayList<>();
            while (dist > 0 && !queue.isEmpty()) {
                CharCount first = queue.poll();
                first.count -= 1;
                tmpList.add(first);
                dist--;
            }

            for (CharCount charCount : tmpList) {
                sb.append(charCount.c);
                if (charCount.count > 0) {
                    queue.add(charCount);
                }
            }
            if (dist > 0 && queue.size() > 0) {
                return "";
            }
        }
        return sb.toString();
    }

    static class CharCount implements Comparable<CharCount> {
        char c;
        int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount o) {
            return this.count != o.count ? o.count - this.count : this.c - o.c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rearrangeString("aaabbc", 3));
    }
}
