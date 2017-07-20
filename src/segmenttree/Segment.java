package segmenttree;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/3/29.
 */
public class Segment {
    int values[];

    Segment(int arr[]) {
        int level = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int maxSize = 2 * (int) Math.pow(2, level) - 1;
        values = new int[maxSize];
        constructUtil(arr, 0, arr.length - 1, 0);
    }

    private int constructUtil(int[] arr, int start, int end, int curIndex) {
        if (start == end) {
            values[curIndex] = arr[start];
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        values[curIndex] = constructUtil(arr, start, mid,curIndex * 2 + 1)
                + constructUtil(arr, mid + 1, end,curIndex * 2 + 2);
        return values[curIndex];
    }

    public int getSum(int s, int e, int n) {
        if (s < 0 || e > n || s > e) {
            return -1;
        }
        return getSumUtil(0, n - 1, s, e, 0);
    }

    private int getSumUtil(int start, int end, int queryStart, int queryEnd, int currentIndex) {
        if (queryStart <= start && queryEnd >= end) {
            return values[currentIndex];
        }

        if (end < queryStart || start > queryEnd) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return getSumUtil(start, mid, queryStart, queryEnd, 2 * currentIndex + 1)
                + getSumUtil(mid + 1, end, queryStart, queryEnd, 2 * currentIndex + 2);
    }

    public static void main(String[] args) {
        Segment segment = new Segment(new int[]{1, 3, 5, 7, 9, 11});
        System.out.println(Arrays.toString(segment.values));
        System.out.println(segment.getSumUtil(0, 5, 1, 2, 0));
    }

}
