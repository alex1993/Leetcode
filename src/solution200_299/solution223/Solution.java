package solution200_299.solution223;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.max(A, E) > Math.min(C, G) ? 0 : (Math.min(C, G) - Math.max(A, E));
        int y = Math.max(B, F) > Math.min(D, H) ? 0 : (Math.min(D, H) - Math.max(B, F));
        return (C - A) * (D - B) + (G - E) * (H - F) - x * y;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(
            -2,
            -2,
            2,
            2,
            -2,
            -2,
            2,
            2));
    }

}
