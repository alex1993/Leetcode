package solution200_299.solution295;

import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/27.
 */
public class MedianFinder {

    private PriorityQueue<Integer> bigger;
    private PriorityQueue<Integer> smaller;

    /** initialize your data structure here. */
    public MedianFinder() {
        //用于保存更大的一部分
        bigger = new PriorityQueue<>();
        //用于保存更小的一部分
        smaller = new PriorityQueue<>(1000, (num1, num2) -> num2 - num1);
    }

    public void addNum(int num) {
        smaller.add(num);
        //把小的一半的最大值放到 大的一半
        bigger.add(smaller.poll());
        //如果小的一半的值太少了，就拿一个大的最小值给小的一半，最终是小的一定不比大的少，因为大的反而抽出一个给了小的
        //所以小的一半用的是最大堆
        if (smaller.size() < bigger.size()) {
            smaller.add(bigger.poll());
        }
    }

    public double findMedian() {
        if (smaller.size() == bigger.size()) {
            return (smaller.peek() + bigger.peek()) / 2.0;
        } else {
            return smaller.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
