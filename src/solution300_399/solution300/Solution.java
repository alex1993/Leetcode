package solution300_399.solution300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/6/12.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private int editDistance(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] copy = new Integer[set.size()];
        set.toArray(copy);
        Arrays.sort(copy);
        int[][] dp = new int[nums.length + 1][copy.length + 1];

        //init: dp[0][j] = 0, dp[i][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < copy.length; j++) {
            dp[0][j] = 0;
        }

        //dp[i][j] = dp[i - 1][j - 1] + 1   if nums[i] == copy[j]
        //dp[i][j] = dp[i - 1][j] (delete from nums)  dp[i][j] = dp[i][j - 1]  (delete from copy)
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                int equal = nums[i] == copy[j] ? dp[i][j] + 1 : dp[i][j];
                int delete = dp[i][j + 1];
                int insert = dp[i + 1][j];
                dp[i + 1][j + 1] = Math.max(equal, Math.max(delete, insert));
            }
        }

        return dp[nums.length][copy.length];
    }

    public int longestIncreasingSubSequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 4};
        System.out.println(solution.lengthOfLIS(nums));
        System.out.println(solution.longestIncreasingSubSequence(nums));

        System.out.println(solution.longestIncreasingSubSequence(new int[]{2, 4, 5, 3}));
    }
}
