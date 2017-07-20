package solution300_399.solution347;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<NumCount> queue = new PriorityQueue<>(k + 1);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            queue.add(new NumCount(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        for (NumCount numCount : queue) {
            res.add(numCount.num);
        }

        return res;
    }

    class NumCount implements Comparable<NumCount> {
        int num;
        int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(NumCount o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
