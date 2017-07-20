package solution400_499.solution477;

/**
 * Script Created by daidai on 2017/6/2.
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int kOnes = 0;
            for (int num : nums) {
                kOnes += (num >> i) & 1;
            }
            total += kOnes * (nums.length - kOnes);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
