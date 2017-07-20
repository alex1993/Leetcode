package solution300_399.solution321;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/20.
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int n = nums1.length;
        int m = nums2.length;
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] left = maxArray(nums1, i);
            int[] right = maxArray(nums2, k - i);
            int[] candidate = merge(left, right, k);
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }

    private boolean greater(int[] left, int i, int[] right, int j) {
        while (i < left.length && j < right.length && left[i] == right[j]) {
            i++;
            j++;
        }
        return j == right.length || (i < left.length && left[i] > right[j]);
    }

    private int[] merge(int[] left, int[] right, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            if (greater(left, i, right, j)) {
                res[r] = left[i++];
            } else {
                res[r] = right[j++];
            }
        }
        return res;
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
                j--;
            if (j < k)
                ans[j++] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}
