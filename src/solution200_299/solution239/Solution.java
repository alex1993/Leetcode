package solution200_299.solution239;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.offer(nums[i]);
                continue;
            }
            queue.offer(nums[i]);
            res[index++] = queue.peek();
            queue.remove(nums[i - k + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1}, 0)));
    }
}
