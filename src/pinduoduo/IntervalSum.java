package pinduoduo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/21.
 */
public class IntervalSum {
    private static class Interval implements Comparable<Interval> {
        private double start;
        private double end;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(@NotNull Interval o) {
            if (this.start != o.start) {
                return this.start - o.start > 0 ? 1 : -1;
            } else {
                return this.end - o.end > 0 ? 1 : -1;
            }
        }
    }

    public double sum(List<Interval> intervalList) {
        Collections.sort(intervalList);
        List<Interval> res = new ArrayList<>();
        double start = intervalList.get(0).start;
        double end = intervalList.get(0).end;

        for (Interval interval : intervalList) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));

        double length = 0;
        for (Interval interval : res) {
            length += interval.end - interval.start;
        }

        return length;
    }

    public static void main(String[] args) {
        IntervalSum intervalSum = new IntervalSum();
        System.out.println(intervalSum.sum(Arrays.asList(new Interval(1.5, 10), new Interval(19, 21))));
    }
}
