package solution300_399.solution373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/27.
 */
public class Solution {

    class Pair implements Comparable<Pair> {
        int[] pair;
        int y; // current index to nums2
        int sum;

        Pair(int y, int n1, int n2) {
            this.y = y;
            pair = new int[]{n1, n2};
            sum = n1 + n2;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return ret;
        int len1 = nums1.length, len2 = nums2.length;

        PriorityQueue<Pair> q = new PriorityQueue<>(k);
        for (int i = 0; i < nums1.length && i < k; i++) { // only need first k number in nums1 to start
            q.offer(new Pair(0, nums1[i], nums2[0]));
        }

        for (int i = 1; i <= k && !q.isEmpty(); i++) { // get the first k sums
            Pair p = q.poll();
            ret.add(p.pair);
            if (p.y < len2 - 1) { // get to next value in nums2
                int next = p.y + 1;
                q.offer(new Pair(next, p.pair[0], nums2[next]));
            }
        }
        return ret;
    }
}

