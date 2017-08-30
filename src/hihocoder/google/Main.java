package hihocoder.google;

import java.util.*;

/**
 * Script Created by daidai on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            List<Point> points = new ArrayList<>();
            List<Point> lines = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                String s = scanner.nextLine().trim();
                String[] nums = s.split(" ");
                int x1 = Integer.parseInt(nums[0]);
                int y1 = Integer.parseInt(nums[1]);
                int x2 = Integer.parseInt(nums[2]);
                int y2 = Integer.parseInt(nums[3]);
                points.add(new Point(x1, y1));
                points.add(new Point(x2, y2));
                lines.add(new Point(x1 - x2, y1 - y2));
            }
            if (pointCount(points) && productRes(lines)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean productRes(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            int zero = 0;
            for (Point point : points) {
                if (points.get(i).product(point) == 0) {
                    zero++;
                }
            }
            if (zero != 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean pointCount(List<Point> points) {
        Map<Point, Integer> map = new HashMap<>();
        for (Point p : points) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 2) {
                return false;
            }
        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        long product(Point p) {
            return p.x * this.x + p.y * this.y;
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
    }
}
