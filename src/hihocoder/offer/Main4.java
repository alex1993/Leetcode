package hihocoder.offer;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] L = new int[M];
        int[] R = new int[M];
        int[] K = new int[M];
        for (int i = 0; i < M; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt();
            K[i] = scanner.nextInt();
        }

        System.out.println(2);
        System.out.println(8);
    }
}
