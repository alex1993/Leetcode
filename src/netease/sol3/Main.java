package netease.sol3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int first = nums[0];
            for (int j = 0; j < n - 1; j++) {
                nums[j] = (nums[(j + n) % n] + nums[(j + 1 + n) % n]) % 100;
            }
            nums[nums.length - 1] = (nums[nums.length - 1] + first) % 100;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }
        if (nums.length > 0) {
            System.out.print(nums[nums.length - 1]);
        }
        System.out.println();
    }
}
