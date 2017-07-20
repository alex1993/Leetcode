package solution600_699.solution624;

/**
 * Script Created by daidai on 2017/6/18.
 */
public class Solution {
    public int maxDistance(int[][] arrays) {
        int[] mins = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            mins[i] = arrays[i][0];
        }

        int[] maxs = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            maxs[i] = arrays[i][arrays[i].length - 1];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < arrays.length; i++) {
            if (mins[i] < min) {
                min = mins[i];
                minIndex = i;
            }
            if (maxs[i] > max) {
                max = maxs[i];
                maxIndex = i;
            }
        }
        if (minIndex != maxIndex) {
            return max - min;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if (j != i) {
                    int dis = Math.abs(maxs[i] - mins[j]);
                    if (dis > res) {
                        res = dis;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(new int[][]{
            {1, 2, 3},
            {4},
        }));
    }
}