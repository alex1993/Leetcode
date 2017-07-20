package solution000_099.solution053;

/**
 * Script Created by daidai on 2017/4/1.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }
        return ans;
    }

    public int solution(int[] nums) {
        int curMax = nums[0], preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            curMax = Math.max(preMax, curMax);
        }
        return curMax;
    }

    public int resolve(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = divideConquer(nums, left, mid);
        int rightSum = divideConquer(nums, mid + 1, right);
        int midSum = midSum(nums, left, right);
        return Math.max(Math.max(leftSum, rightSum), midSum);
    }

    public int midSum(int[] A, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for (int i = mid; i >= left; i--) {
            sum = sum + A[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum = sum + A[j];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.resolve(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
