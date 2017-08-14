package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/9.
 */
public class Main4 {

    //一个字符串能够组成的最少回文串的数目，如果都是偶数个，那么都可以组成一个大的回文串
    //如果有奇数长度的，那么可以把一个奇数串加到偶数串中，但是剩下的奇数串都只能剩下长度为1的串
    private static int minPalindromeCount(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(minPalindromeCount(scanner.next()));
    }
}
