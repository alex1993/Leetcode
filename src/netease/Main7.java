package netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }

        //1 100 1 100
        Set<Double> set = new HashSet<>();
        for (int i = nums[0]; i <= nums[1]; i++) {
            for (int j = nums[2]; j <= nums[3]; j++) {
                set.add((i* 1.0) / j);
            }
        }
        System.out.println(set.size());
    }
}
