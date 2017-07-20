package solution000_099.solution085;

import java.util.Stack;

/**
 * Script Created by daidai on 2017/3/30.
 */
public class Solution {
    /**
     * 计算最大面积的时候，对于点 i, j，那么 area = (right(i, j) - left(i, j)) * height(i, j)
     * 即面积是，当前点所能达到最左边界，最右边界，和高度的乘积
     * 那么对于高度而言，如果 mat[i][j] == 1，那么高度就是 前一层的高度 + 1 了
     * 对于 left 而言，如果 mat[i][j] == 1，那么能达到最左边界不仅受到 当前这一层的左边界（就是和当前点连续的 1 的位置） 影响，
     * 还受到上一层节点的左边界影响，所以 left[j] = max(left[j], curLeft)
     * 同理，对于右边界，则是从右往左走
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxA = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        for (int i = 0; i < left.length; i++) {
            left[i] = 0;
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = n;
        }

        for (int i = 0; i < m; i++) {
            int curL = 0, curR = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curL, left[j]);
                } else {
                    left[j] = 0;
                    curL = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curR, right[j]);
                } else {
                    right[j] = n;
                    curR = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }
        return maxA;
    }

    public int maxArea(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            //init height
            for (int k = 0; k < n; k++) {
                if (matrix[i][k] == '1') {
                    height[k] += 1;
                } else {
                    height[k] = 0;
                }
            }

            //compute area for histogram
            int j = 0;
            while (j < n) {
                if (stack.isEmpty() || height[stack.peek()] <= height[j]) {
                    stack.push(j);
                    j++;
                } else {
                    int top = stack.pop();
                    int area = height[top] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                    max = Math.max(max, area);
                }

            }
            while (!stack.empty()) {
                int top = stack.pop();
                int area = height[top] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new char[][]{
            {'1', '0', '1', '0', '0',},
            {'1', '0', '1', '1', '1',},
            {'1', '1', '1', '1', '1',},
            {'1', '0', '0', '1', '0',},}
        ));
    }
}
