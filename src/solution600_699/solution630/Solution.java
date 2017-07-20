package solution600_699.solution630;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/25.
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {
        List<Task> tasks = new ArrayList<>();
        for (int[] cours : courses) {
            tasks.add(new Task(cours[0], cours[1]));
        }
        Collections.sort(tasks);

        List<Task> emptyTask = new ArrayList<>();
        List<Task> res = new ArrayList<>();
        for (Task task : tasks) {
            if (res.isEmpty()) {
                res.add(task);
                task.actualEndTime = task.duration;
                continue;
            }
            if (task.latestStartTime >= res.get(res.size() - 1).actualEndTime) {
                task.actualEndTime = res.get(res.size() - 1).actualEndTime + task.duration;
                res.add(task);
            }
        }
        return res.size();
    }

    class Task implements Comparable<Task> {
        int duration;
        int endTime;
        int latestStartTime;
        int actualEndTime;

        public Task(int duration, int endTime) {
            this.duration = duration;
            this.endTime = endTime;
            latestStartTime = this.endTime - this.duration;
        }

        @Override
        public int compareTo(Task o) {
            return this.duration - o.duration;
        }

        @Override
        public String toString() {
            return "Task{" +
                       "duration=" + duration +
                       ", endTime=" + endTime +
                       ", latestStartTime=" + latestStartTime +
                       '}';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}));
        System.out.println(solution.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }
}
