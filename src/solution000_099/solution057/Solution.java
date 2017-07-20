package solution000_099.solution057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Script Created by daidai on 2017/5/25.
 */
// * Definition for an interval.
class Interval {
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
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return Collections.singletonList(newInterval);
        }

        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);

        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval[] intervals = new Interval[]{
            new Interval(1, 2),
            new Interval(3, 5),
            new Interval(6, 7),
            new Interval(8, 10),
            new Interval(12, 16),
        };
        System.out.println(solution.insert(Arrays.asList(intervals), new Interval(4, 9)));
    }
}
