package segmenttree;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/3/29.
 */
public class RangeMinimumQuery {
    int[] values;

    RangeMinimumQuery(int[] array) {
        int level = (int) (Math.ceil(Math.log(array.length) / Math.log(2)));
        int maxSize = (int) (2 * Math.pow(2, level)) - 1;
        values = new int[maxSize];
        segmentUtil(0, array.length - 1, array, 0);
    }

    private int segmentUtil(int start, int end, int[] array, int curIndex) {
        if (start == end) {
            values[curIndex] = array[start];
            return values[curIndex];
        }

        int mid = start + (end - start) / 2;
        values[curIndex] = Math.min(segmentUtil(start, mid, array, 2 * curIndex + 1),
                segmentUtil(mid + 1, end, array, 2 * curIndex + 2));
        return values[curIndex];
    }

    public int query(int queryStart, int queryEnd, int n) {
        if (queryEnd < queryStart) {
            return -1;
        }
        return queryUtil(0, n - 1, queryStart, queryEnd, 0);
    }

    private int queryUtil(int start, int end, int queryStart, int queryEnd, int curIndex) {
        if (start >= queryStart && end <= queryEnd) {
            return values[curIndex];
        }

        if (end < queryStart || start > queryEnd) {
            return Integer.MAX_VALUE;
        }
        int mid = start + (end - start) / 2;
        return Math.min(queryUtil(start, mid, queryStart, queryEnd, 2 * curIndex + 1),
                queryUtil(mid + 1, end, queryStart, queryEnd, 2 * curIndex + 2));
    }

    public static void main(String[] args) {
        RangeMinimumQuery rangeMinimumQuery = new RangeMinimumQuery(new int[]{2, 5, 1, 4, 9, 3});
        System.out.println(Arrays.toString(rangeMinimumQuery.values));
        System.out.println(rangeMinimumQuery.query(1, 5, 6));
    }
}
