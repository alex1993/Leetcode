package alibaba;

/**
 * Script Created by daidai on 2017/8/2.
 */

import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int cut(int[] parts) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int part : parts) {
            queue.add(part);
        }
        int size = queue.size();
        int res = 0;
        for (int i = 0; i < size - 1; i++) {
            Integer one = queue.poll();
            Integer two = queue.poll();
            queue.add(one + two);
            res += one + two;
        }

        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }
}
