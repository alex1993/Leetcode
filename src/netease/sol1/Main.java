package netease.sol1;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pointNum = scanner.nextInt();

        Point[] points = new Point[pointNum];
        for (int i = 0; i < pointNum; i++) {
            points[i] = new Point();
        }
        for (int i = 0; i < pointNum; i++) {
            points[i].x = scanner.nextInt();
        }
        for (int i = 0; i < pointNum; i++) {
            points[i].y = scanner.nextInt();
        }

        int gx = scanner.nextInt();
        int gy = scanner.nextInt();

        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();

        int[] taxiTotal = new int[pointNum];
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int timeTo = timeToTaxi(points[i], walkTime);
            int timeToGx = timeToGx(gx, gy, points[i], taxiTime);
            taxiTotal[i] = timeTo + timeToGx;
            if (taxiTotal[i] < minTime) {
                minTime = taxiTotal[i];
            }
        }

        int walkTotal = total(gx, gy, walkTime);
        System.out.println(Math.min(minTime, walkTotal));
    }

    private static int timeToTaxi(Point taxiPoint, int walkTime) {
        return (Math.abs(taxiPoint.x) + Math.abs(taxiPoint.y)) * walkTime;
    }

    private static int timeToGx(int gx, int gy, Point taxiPoint, int taxiTime) {
        return (Math.abs((gx - taxiPoint.x)) + Math.abs((gy - taxiPoint.y))) * taxiTime;
    }

    private static int total(int gx, int gy, int walkTime) {
        return (Math.abs(gx) + Math.abs(gy)) * walkTime;
    }
}

class Point {
    int x;
    int y;
    Point() {

    }

}
