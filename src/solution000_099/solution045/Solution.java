package solution000_099.solution045;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/5/20.
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int level = 0, currentMax = 0, i = 0, nextMax = 0;
        while (i <= currentMax) {
            level++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return 0;
    }

    //fixme: TLE ERROR
    public int solve(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int bfs(int[] nums) {
        //使用宽度优先的方法，level表示当前到了第几层，curMax表示当前这一层最远能够到达的位置，
        //如果这一次到达了最远位置，则层数 + 1，在遍历当前层的时候，同时更新下一层最远的到达点
        int level = 0;
        int nextMax = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax) {
                level++;
                curMax = nextMax;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.bfs(new int[]{2, 1}));
    }
}
