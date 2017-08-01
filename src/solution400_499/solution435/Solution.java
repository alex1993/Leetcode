package solution400_499.solution435;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/28.
 */
class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(@NotNull Interval o) {
        return this.end != o.end ? this.end - o.end : this.start - o.start;
    }
}

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1.end != o2.end ? o1.end - o2.end : o1.start - o2.start);
        int start = intervals[0].start;
        int end = intervals[0].end;
        int remain = 1;
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];
            if (interval.start < end) {
                continue;
            }
            end = Math.max(end, interval.end);
            remain++;
        }
        return intervals.length - remain;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new Interval[]{
            new Interval(2, 3)}));
    }
}
