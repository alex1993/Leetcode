package solution400_499.solution451;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[128];
        for (char c : chars) {
            hash[c]++;
        }

        int size = 0;
        for (int i = 0; i < hash.length; i++) {
            size = Math.max(hash[i], size);
        }

        List[] lists = new ArrayList[size + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                lists[hash[i]].add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i].size() > 0) {
                for (Object c : lists[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append((char) (int) c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("Aabb"));
    }
}
