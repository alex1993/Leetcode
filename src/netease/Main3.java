package netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main3 {

    //只移动男生或者女生，男生都往左移，其实就是女生都往右移
    private static int minMove(String string, char boyGirl) {
        //记录一下当前男生是第几个，当前男生要移动的次数是，index - 第几个
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == boyGirl) {
                map.put(i, count);
                count++;
            }
        }
        int leftRes = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            leftRes += entry.getKey() - entry.getValue();
        }
        return leftRes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int moveBoy = minMove(string, 'B');
        int moveGirl = minMove(string, 'G');
        System.out.println(Math.min(moveBoy, moveGirl));
    }
}
