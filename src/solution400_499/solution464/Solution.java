package solution400_499.solution464;

import java.util.*;

/**
 * Script Created by daidai on 2017/7/19.
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (total < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        return sum(desiredTotal, new boolean[maxChoosableInteger + 1], new HashMap<>());
    }

    private boolean sum(int desiredTotal, boolean[] used, Map<Integer, Boolean> map) {
        int cur = arrayToInt(used);
        if (map.containsKey(cur)) {
            return map.get(cur);
        }

        for (int i = 1; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (desiredTotal <= i || !sum(desiredTotal - i, used, map)) {
                used[i] = false;
                map.put(cur, true);
                return true;
            }
            used[i] = false;
        }
        map.put(cur, false);
        return false;
    }

    private int arrayToInt(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) {
                num |= 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canIWin(15, 105));
    }
}
