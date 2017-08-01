package solution600_699.solution630;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {
        //紧急的任务优先
        Arrays.sort(courses, (task1, task2) -> task1[1] - task2[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            queue.offer(course[0]);
            if (time > course[1]) {
                time -= queue.poll();
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}));
        System.out.println(solution.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }
}
