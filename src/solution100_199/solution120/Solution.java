package solution100_199.solution120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/12.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        //init res as triangle
        for (List<Integer> list : triangle) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer num : list) {
                tmp.add(0);
            }
            res.add(tmp);
        }

        //if j == 0, dp[i][j] = dp[i - 1][j] + nums[i][j]
        //if j == size - 1, dp[i][j] = dp[i - 1][j - 1] + nums[i][j]
        //else dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + nums[i][j]
        //dp[0][0] = nums[0][0]
        res.get(0).set(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    res.get(i).set(j, res.get(i - 1).get(j) + cur);
                } else if (j == res.get(i).size() - 1) {
                    res.get(i).set(j, res.get(i - 1).get(j - 1) + cur);
                } else {
                    res.get(i).set(j, Math.min(res.get(i - 1).get(j - 1), res.get(i - 1).get(j)) + cur);
                }
            }
        }
        int sum = Integer.MAX_VALUE;
        for (Integer num : res.get(res.size() - 1)) {
            sum = Math.min(num, sum);
        }
        return sum;
    }

    private int solve(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] hash = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        return dfs(triangle, hash, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int[][] hash, int x, int y) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        if (hash[x][y] != Integer.MAX_VALUE) {
            return hash[x][y];
        }
        int left = dfs(triangle, hash, x + 1, y);
        int right = dfs(triangle, hash, x + 1, y + 1);
        hash[x][y] = Math.min(left, right) + triangle.get(x).get(y);
        return hash[x][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        )));
    }
}
