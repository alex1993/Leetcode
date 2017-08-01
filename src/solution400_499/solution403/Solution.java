package solution400_499.solution403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Script Created by daidai on 2017/7/20.
 */
public class Solution {
    private boolean solve(int[] stones) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1);

        int target = stones[stones.length - 1];
        for (int stone : stones) {
            HashSet<Integer> steps = map.get(stone);
            for (Integer step : steps) {
                int sum = step + stone;
                if (sum == target) {
                    return true;
                }
                if (map.containsKey(sum)) {
                    if (step > 1) {
                        map.get(sum).add(step - 1);
                    }
                    map.get(sum).add(step);
                    map.get(sum).add(step + 1);
                }
            }
        }
        return false;
    }

    //TLE!!
    public boolean canCross(int[] stones) {
        if (stones == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int stone : stones) {
            set.add(stone);
        }
        int finalStone = stones[stones.length - 1];
        return dfs(set, finalStone, 0, 0);
    }

    private boolean dfs(Set<Integer> stones, int finalStone, int cur, int step) {
        if (cur == finalStone) {
            return true;
        }
        for (int i = step + 2 - 1; i >= Math.max(1, step - 1); i--) {
            int next = cur + i;
            if (stones.contains(next)) {
                stones.remove(next);
                if (dfs(stones, finalStone, next, i)) {
                    stones.add(next);
                    return true;
                }
                stones.add(next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
        System.out.println(solution.solve(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}