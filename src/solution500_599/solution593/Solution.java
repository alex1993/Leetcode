package solution500_599.solution593;

import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/7/18.
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Long> lengths = new HashSet<>();
        lengths.add(distance(p1, p2));
        lengths.add(distance(p2, p3));
        lengths.add(distance(p3, p4));
        lengths.add(distance(p4, p1));
        lengths.add(distance(p1, p3));
        lengths.add(distance(p2, p4));
        return !lengths.contains((long) 0) && lengths.size() == 2;
    }

    private long distance(int[] p1, int[] p2) {
        return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validSquare(
            new int[]{0, 2},
            new int[]{1, 1},
            new int[]{1, 0},
            new int[]{0, 1}
        ));
    }
}
