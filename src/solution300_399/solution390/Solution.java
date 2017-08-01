package solution300_399.solution390;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/31.
 */
public class Solution {
    //fixme: TLE (O(n^2))
    public int lastRemaining(int n) {
        List<Integer> copy = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            copy.add(i);
        }

        boolean start = true;
        while (copy.size() > 1) {
            List<Integer> tmp = new ArrayList<>();
            int s = 1;
            if (!start && copy.size() % 2 == 0) {
                s = 0;
            }
            while (s < copy.size()) {
                tmp.add(copy.get(s));
                s += 2;
            }
            copy = tmp;
            start = !start;
        }
        return copy.get(0);
    }

    public int solve(int n) {
        boolean left = true;
        int head = 1;
        int remaining = n;
        int step = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head += step;
            }
            step *= 2;
            left = !left;
            remaining /= 2;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(9));
    }
}
