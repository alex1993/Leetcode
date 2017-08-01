package solution300_399.solution384;

import java.util.Arrays;
import java.util.Random;

/**
 * Script Created by daidai on 2017/7/30.
 */
public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = nums.clone();
        for (int i = 1; i < copy.length; i++) {
            int id = random.nextInt(i + 1);
            swap(copy, i, id);
        }
        return copy;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
