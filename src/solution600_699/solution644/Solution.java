package solution600_699.solution644;

/**
 * Script Created by daidai on 2017/7/16.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        //maxSum表示直到index i的 max sum(inclusive)
        int maxSum[] = new int[n];
        maxSum[0] = nums[0];

        int curMax = nums[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum[i] = curMax;
        }

        // Sum of first k elements
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        // Use the concept of sliding window
        int result = sum;
        for (int i = k; i < n; i++) {
            sum += (nums[i] - nums[i - k]);

            // Update result if required
            result = Math.max(result, sum);
            // Include maximum sum till [i-k] also
            // if it increases overall max.
            result = Math.max(result, sum + maxSum[i - k]);
        }
        return result;
    }
}
