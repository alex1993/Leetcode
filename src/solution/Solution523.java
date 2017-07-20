package solution;

/**
 * Script Created by daidai on 2017/2/26.
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        int tmpSum = 0;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int j = 1; j < sums.length; j++) {
            for (int i = j + 1; i < sums.length; i++) {
                if (sums[i] % k == 0) {
                    return true;
                } else {
                    sums[i] = sums[i] - sums[j];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 solution523 = new Solution523();
        System.out.println(solution523.checkSubarraySum(new int[]{0, 0}, -1));
    }
}
