package solution100_199.solution149;

import structure.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/6/19.
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            //map contains deltaX - deltaY counts
            Map<Delta, Integer> map = new HashMap<>();
            int overlap = 0;
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j].x - points[i].x;
                int deltaY = points[j].y - points[i].y;
                int gcd = gcd(deltaX, deltaY);
                if (deltaX == 0 && deltaY == 0) {
                    overlap++;
                    continue;
                }
                deltaX /= gcd;
                deltaY /= gcd;

                Delta delta = new Delta(deltaX, deltaY);
                map.put(delta, map.getOrDefault(delta, 0) + 1);
            }
            int max = 0;
            for (Map.Entry<Delta, Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }
            res = Math.max(res, max + 1 + overlap);
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    class Delta {
        int dx;
        int dy;

        public Delta(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Delta delta = (Delta) o;

            if (dx != delta.dx) return false;
            return dy == delta.dy;
        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(0, 0);
        System.out.println(solution.maxPoints(new Point[]{point1, point2, point3}));
    }
}
