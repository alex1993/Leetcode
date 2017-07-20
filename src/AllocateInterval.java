import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Script Created by daidai on 2017/5/31.
 */
public class AllocateInterval {
    public List<List<Interval>> allocate(Interval[] intervals) {
        Arrays.sort(intervals);
        List<List<Interval>> res = new ArrayList<>();
        int pre = -1;
        for (Interval interval : intervals) {
            int count = 0;
            for (int j = 0; j < res.size(); j++) {
                int curListIndex = (pre - j + res.size()) % res.size();
                List<Interval> cur = res.get(curListIndex);
                Interval last = cur.get(cur.size() - 1);
                if (!overlap(last, interval)) {
                    pre = curListIndex;
                    cur.add(interval);
                } else {
                    count++;
                }
            }
            if (count == res.size()) {
                List<Interval> intervalList = new ArrayList<>();
                intervalList.add(interval);
                res.add(intervalList);
                pre = res.size() - 1;
            }
        }
        return res;
    }

    private boolean overlap(Interval int1, Interval int2) {
        return int1.e > int2.s;
    }

    public static void main(String[] args) {
        AllocateInterval allocateInterval = new AllocateInterval();
        Interval[] intervals = new Interval[]{
            new Interval(1, 2),
            new Interval(3, 4),
            new Interval(3, 5),
            new Interval(3, 6),
            new Interval(4, 7),
        };
        System.out.println(allocateInterval.allocate(intervals));
    }

    public static class Interval implements Comparable<Interval> {
        int s;
        int e;

        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Interval o) {
            return (this.s - o.s) != 0 ? (this.s - o.s) : (this.e - o.e);
        }

        @Override
        public String toString() {
            return "Interval{" +
                       "s=" + s +
                       ", e=" + e +
                       '}';
        }
    }
}
