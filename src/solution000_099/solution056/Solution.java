package solution000_099.solution056;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/22.
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
    public int compareTo(Interval o) {
        return this.end - o.end != 0 ? this.end - o.end : this.start - o.start;
    }

    @Override
    public String toString() {
        return "Interval{" +
                   "start=" + start +
                   ", end=" + end +
                   '}';
    }
}

public class Solution {

    public List<Interval> solve(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals);
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (res.isEmpty()) {
                res.add(intervals.get(i));
                continue;
            }
            Interval comp1 = res.get(res.size() - 1);
            Interval comp2 = intervals.get(i);
            while (overlap(comp1, comp2)) {
                res.remove(res.size() - 1);
                comp2 = merge(comp1, comp2);
                if (res.size() > 0) {
                    comp1 = res.get(res.size() - 1);
                } else {
                    break;
                }
            }
            res.add(comp2);
        }
        return res;
    }

    private boolean overlap(Interval interval1, Interval interval2) {
        return interval1.end - interval2.start >= 0;
    }

    private Interval merge(Interval interval1, Interval interval2) {
        return new Interval(Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval[] interval = new Interval[]{
            new Interval(2, 3),
            new Interval(4, 5),
            new Interval(6, 7),
            new Interval(8, 9),
            new Interval(1, 10),
        };
        System.out.println(solution.solve(Arrays.asList(interval)));
    }
}
