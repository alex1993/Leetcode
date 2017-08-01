package solution400_499.solution480;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }
        //所有比mid更小的值存放在这里，使用最大堆
        PriorityQueue<Double> smaller = new PriorityQueue<>((num1, num2) -> Double.compare(num2, num1));
        PriorityQueue<Double> bigger = new PriorityQueue<>();

        k--;
        double[] res = new double[nums.length - k];
        for (int i = 0; i < nums.length; i++) {
            //新来一个元素，先在smaller里头走一圈，然后更新了堆之后再取出最大的元素
            smaller.offer((double) nums[i]);
            bigger.offer(smaller.poll());
            if (bigger.size() > smaller.size()) {
                //大小不平衡了，取出最小堆中的元素放到最大堆里头
                smaller.offer(bigger.poll());
            }
            if (i >= k) {
                //要提取出的值根据两个队列的size得出，偶数则是中指，基数则是在更小的队列中
                double cur;
                if (smaller.size() == bigger.size()) {
                    cur = (smaller.peek() + bigger.peek()) / 2.0;
                } else {
                    cur = smaller.peek();
                }
                res[i - k] = cur;

                //如果要删除的元素在右边，则从更大的队列中删除
                double toRemove = nums[i - k];
                if (toRemove > cur) {
                    bigger.remove(toRemove);
                    bigger.offer(smaller.poll());
                } else {
                    smaller.remove(toRemove);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
    }
}
