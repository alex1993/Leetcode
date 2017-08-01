package solution600_699.solution646;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/23.
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] last = new int[]{pairs[0][0], pairs[0][1]};
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            int[] cur = pairs[i];
            if (cur[0] > last[1]) {
                count++;
                last[1] = cur[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestChain(new int[][]{
            {1, 2},
            {2, 3},
            {3, 4}
        }));
    }
}
