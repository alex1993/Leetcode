package pinduoduo;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/21.
 */
public class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateMatrix.rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
