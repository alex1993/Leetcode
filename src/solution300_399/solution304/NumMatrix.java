package solution300_399.solution304;

/**
 * Script Created by daidai on 2017/6/16.
 */
public class NumMatrix {

    private int[][] total;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        total = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                total[i][j] = total[i - 1][j] + total[i][j - 1] - total[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return total[row2 + 1][col2 + 1] - total[row1][col2 + 1] - total[row2 + 1][col1] + total[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
            {-4, -5}
        });
//        System.out.println(numMatrix.sumRegion(0, 0, 4, 3));
//        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1));
    }
}

/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
