package solution300_399.solution396;

/**
 * Script Created by daidai on 2017/7/31.
 */
public class Solution {
    //O(n^2)
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] copy = new int[n * 2];
        for (int i = 0; i < n; i++) {
            copy[i] = A[i];
            copy[i + n] = A[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += j * copy[j + i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    public int solve(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int n = A.length;
        int sum = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            res += i * A[i];
        }

        int max = res;
        for (int j = 0; j < n - 1; j++) {
            res += sum - n * A[n - 1 - j];
            max = Math.max(res, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{4, 3, 2, 6}));
    }
}
