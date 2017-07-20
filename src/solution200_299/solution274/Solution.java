package solution200_299.solution274;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                bucket[n]++;
            } else {
                bucket[citation]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
