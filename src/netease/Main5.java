package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[][] baseMatrix = new int[n][n];//基准矩阵
        for (int i = 0; i < baseMatrix.length; i++) {
            baseMatrix[i][i] = 1;
            if (i == baseMatrix.length - 1)
                baseMatrix[0][i] = 1;
            else {
                baseMatrix[i + 1][i] = 1;
            }
        }
        int[][] factor = pow(baseMatrix, k);
        int[] result = singleMatrixProduct(nums, factor);

        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(result[result.length - 1]);

    }

    //快速幂
    private static int[][] pow(int[][] baseMatrix, int num) {
        if (num == 1) {
            return baseMatrix;
        }
        if (num % 2 == 0) {
            return pow(product(baseMatrix, baseMatrix), num / 2);
        } else {
            return product(pow(baseMatrix, num - 1), baseMatrix);
        }
    }

    private static int[][] product(int[][] left, int[][] right) {
        int[][] res = new int[left.length][right[0].length];
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right[0].length; j++) {
                for (int k = 0; k < left[0].length; k++) {
                    res[i][j] += left[i][k] * right[k][j];
                    res[i][j] %= 100;
                }
            }
        }
        return res;
    }

    public static int[] singleMatrixProduct(int[] matrixLeft, int[][] matrixRight) {
        int[] res = new int[matrixLeft.length];
        for (int j = 0; j < matrixRight[0].length; j++) {
            for (int k = 0; k < matrixLeft.length; k++) {
                res[j] += matrixLeft[k] * matrixRight[k][j];
                res[j] %= 100;
            }
        }
        return res;
    }
}
