

import java.util.ArrayList;
import java.util.Scanner;

public class Alibaba {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static boolean resolve(int[] A) {
        int a = 0;
        int b = 1;
        int c = 2;
        long W = 0;
        long X = 0;
        long Y = 0;
        long Z = sum(A, c + 1);
        while (true) {
            if (Y < Z) {
                c++;
                Y += A[c - 1];
                Z -= A[c];
                continue;
            }
            if (X < Y) {
                b++;
                X += A[b - 1];
                Y -= A[b];
                continue;
            }
            if (W < X) {
                a++;
                W += A[a - 1];
                X -= A[a];
                continue;
            }
            if (W == X && X == Y && Y == Z) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static long sum(int[] A, int start) {
        long sum = 0;
        for (int i = start; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if (value == 0)
                break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            A[i] = inputs.get(i);
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}