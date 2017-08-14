package hihocoder.offer;

import java.util.*;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Main3 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                       "x=" + x +
                       ", y=" + y +
                       '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 1) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            System.out.println(x0 + " " + y0 + " " + x1 + " " + y1);
            return;
        }

        Map<Point, Integer> map = new HashMap<>();
        Set<Point> border = new HashSet<>();
        Set<Point> candidateBorder = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            Point[] points = new Point[]{new Point(x0, y0), new Point(x0, y1), new Point(x1, y1), new Point(x1, y0)};
            for (Point p : points) {
                if (i == 0) {
                    border.add(p);
                    candidateBorder.add(p);
                } else {
                    candidateBorder.remove(p);
                }
                if (!map.containsKey(p)) {
                    map.put(p, 0);
                }
                map.put(p, map.get(p) + 1);
            }
        }


        List<Point> candidate = new ArrayList<>();
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0 && !border.contains(entry.getKey())) {
                candidate.add(entry.getKey());
            }
        }
        if (candidate.size() < 4) {
            candidate.addAll(candidateBorder);
        }
        int xMin = candidate.get(0).x;
        int yMin = candidate.get(0).y;
        int xMax = candidate.get(0).x;
        int yMax = candidate.get(0).y;
        for (Point point : candidate) {
            xMin = Math.min(xMin, point.x);
            yMin = Math.min(yMin, point.y);
            xMax = Math.max(xMax, point.x);
            yMax = Math.max(yMax, point.y);
        }
        System.out.println(xMin + " " + yMin + " " + xMax + " " + yMax);
    }
}
