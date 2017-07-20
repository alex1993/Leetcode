package wap.wap2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ubuntu on 5/20/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; ++ i) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(modable(nums, m) ? "Yes" : "No");
    }

    static boolean modable(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            Set<Integer> ns = new HashSet<>();
            ns.add(n % target);
            for(int k : set) {
                ns.add((k + n) % target);
            }
            set.addAll(ns);
        }
        return set.contains(0);
    }
}
