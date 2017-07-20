package solution600_699.solution632;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/7/2.
 */
public class Solution {
    class Num implements Comparable<Num> {
        int num;
        int index;
        int arr;

        public Num(int num, int index, int arr) {
            this.num = num;
            this.index = index;
            this.arr = arr;
        }

        @Override
        public int compareTo(Num o) {
            return this.num - o.num;
        }
    }

    public int[] smallestRange(int[][] nums) {
        PriorityQueue<Num> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new Num(nums[i][0], 0, i));
        }

        int maxInQueue = Integer.MIN_VALUE;
        for (Num num : queue) {
            if (num.num > maxInQueue) {
                maxInQueue = num.num;
            }
        }

        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Num first = queue.poll();
            if (maxInQueue - first.num < range) {
                range = maxInQueue - first.num;
                res = new int[]{first.num, maxInQueue};
            }
            int arr = first.arr;
            if (first.index < nums[arr].length - 1) {
                queue.offer(new Num(nums[arr][first.index + 1], first.index + 1, arr));
                maxInQueue = Math.max(maxInQueue, nums[arr][first.index + 1]);
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.smallestRange(new int[][]{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}});
        System.out.println(Arrays.toString(res));
    }
}
