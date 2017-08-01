package solution400_499.solution452;

import util.ParseUtil;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/7/28.
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        //根据start进行排序
        Arrays.sort(points, (point1, point2) -> point1[0] - point2[0]);
        //目标是找到穿透所有balloons的最小箭的数目，所以其实可以统计重叠的数目

        int count = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int[] point : points) {
            int s = point[0];
            int e = point[1];
            if (s <= end) {
                start = Math.max(s, start);
                end = Math.min(e, end);
            } else {
                count++;
                start = s;
                end = e;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(ParseUtil.parseArrays("[[1,2],[2,3],[3,4],[4,5]]")));
    }
}
