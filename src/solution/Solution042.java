package solution;

/**
 * Script Created by daidai on 2017/2/15.
 */
public class Solution042 {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;;
        int max = 0;
        while (i < j) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            if (height[j] > rightMax) {
                rightMax = height[j];
            }
            if (leftMax < rightMax) {
                max += (leftMax - height[i]);
                i++;
            } else {
                max += (rightMax - height[j]);
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution042 solution042 = new Solution042();
        System.out.println(solution042.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
