package solution300_399.solution322;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/20.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int amount, int[] coinCount) {
        if (amount == 0) {
            return 0;
        }
        if (coinCount[amount] != 0) {
            return coinCount[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            int min = helper(coins, amount - coins[i], coinCount);
            if (min >= 0) {
                res = Math.min(min + 1, res);
            }
        }
        coinCount[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return coinCount[amount];
    }

    private int solve(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] count = new int[amount + 1];
        for (int i = 0; i < amount; i++) {
            //如果不是第一个，并且之前没有硬币可以组成当前 i，那么直接跳过
            if (i != 0 && count[i] == 0) {
                continue;
            }
            for (int coin : coins) {
                //当超出amount的时候，直接跳过当前硬币，不过有可能会有溢出的情况
                if (coin + i > amount || coin + i < 0) {
                    continue;
                }
                //第一次有硬币组合出现，那么就是之前的 + 1，否则需要取最小值
                if (count[i + coin] == 0) {
                    count[i + coin] = count[i] + 1;
                } else {
                    count[i + coin] = Math.min(count[i + coin], count[i] + 1);
                }
            }
        }
        return count[amount] == 0 ? -1 : count[amount];
    }

    private int bottomUp(int[] coins, int amount) {
        //count[i] 达到 i 所需要的硬币数目
        //if i >= coins[i]
        //count[i] = min{count[i - coins[0]], count[i - coins[1]], ...} + 1
        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    count[i] = Math.min(count[i], count[i - coin] + 1);
                }
            }
        }
        return count[amount] > amount ? -1 : count[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{1, 2147483647}, 2));
    }
}
