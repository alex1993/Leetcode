package hihocoder.offer;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //统计一下 2 前边有几个 1，并累加
        long ones = 0;
        long twos = 0;
        long res = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            } else if (num == 2) {
                twos += ones;
            } else {
                res += twos;
            }
        }
        System.out.println(res);
    }
}
