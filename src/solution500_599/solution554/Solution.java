package solution500_599.solution554;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Script Created by daidai on 2017/4/9.
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //map for width -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = wall.size();
        for (Integer key : map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;

    }

    private List<List<Integer>> parseArray(int[][] ints) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < ints[i].length; j++) {
                row.add(ints[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.parseArray(new int[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}});
        System.out.println(solution.leastBricks(lists));
    }
}
