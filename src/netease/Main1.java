package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main1 {

    public static int partitionClosest(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = sum;
        sum /= 2;
        //dp[i]表示nums的数组能否组成和为i的序列
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                //不包含或者包含当前 num 能够组成序列 i
                dp[i] = dp[i] || dp[i - num];
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                return Math.max(i, total - i);
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();
        int[] tasks = new int[taskNum];
        for (int i = 0; i < taskNum; i++) {
            tasks[i] = scanner.nextInt() / 1024;
        }
        int res = partitionClosest(tasks);
        System.out.println(res * 1024);
    }
}
