package netease;

/**
 * Script Created by daidai on 2017/7/31.
 */
public class TuHao {
    //fixme: index out of bounds error
    private int[][] calSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < sum.length; i++) {
            sum[i][0] = matrix[i][0] + sum[i - 1][0];
        }
        for (int j = 1; j < sum.length; j++) {
            sum[0][j] = matrix[0][j] + sum[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
            }
        }
        return sum;
    }

    private boolean greaterThan(int[][] sum, int key) {
        int m = sum.length;
        int n = sum[0].length;
        for (int i = 1; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int preI = 0, count = 0;
                    for (int h = 1; h <= n; h++) {
                        int area1 = calArea(preI, 0, h, i - 1, sum);
                        int area2 = calArea(preI, i, h, j - 1, sum);
                        int area3 = calArea(preI, j, h, k - 1, sum);
                        int area4 = calArea(preI, k, h, n - 1, sum);
                        if (area1 >= key && area2 >= key && area3 >= key && area4 >= key) {
                            count++;
                            preI = i;
                        }
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //area start inclusive, end inclusive
    private int calArea(int sX, int sY, int eX, int eY, int[][] sum) {
        return sum[eX][eY] - sum[sX][eY] - sum[eX][sY] + sum[sX][sY];
    }



    public static void main(String[] args) {
        TuHao tuHao = new TuHao();
        int[][] matrix = new int[][] {
            {3, 3, 3, 2},
            {3, 2, 3, 3},
            {3, 3, 3, 2},
            {2, 3, 2, 3}
        };
        int[][] sum = tuHao.calSum(matrix);
        int low = 0, high = sum[matrix.length - 1][matrix[0].length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (tuHao.greaterThan(sum, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
}
