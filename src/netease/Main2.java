package netease;

import java.util.Scanner;

/**
 * Script Created by daidai on 2017/8/7.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taxiCount = scanner.nextInt();
        int[][] taxiPoints = new int[taxiCount][2];
        for (int i = 0; i < taxiCount; i++) {
            taxiPoints[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < taxiCount; i++) {
            taxiPoints[i][1] = scanner.nextInt();
        }

        int[] target = new int[]{scanner.nextInt(), scanner.nextInt()};
        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();

        int res = Integer.MAX_VALUE;
        int[] cur = new int[]{0, 0};
        for (int i = 0; i < taxiPoints.length; i++) {
            int taxiDist = dist(cur, taxiPoints[i]);
            int taxiTargetDist = dist(taxiPoints[i], target);
            res = Math.min(res, taxiDist * walkTime + taxiTargetDist * taxiTime);
        }

        int onlyWalk = dist(cur, target) * walkTime;
        res = Math.min(res, onlyWalk);
        System.out.println(res);
    }

    private static int dist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
