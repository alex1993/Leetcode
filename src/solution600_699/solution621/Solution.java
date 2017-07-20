package solution600_699.solution621;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Script Created by daidai on 2017/6/18.
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        int[] hash = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            hash[tasks[i] - 'A']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                queue.add(new Task((char) ('A' + i), hash[i]));
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            List<Task> tmpList = new ArrayList<>();
            int intervalNeed = n + 1;
            while (intervalNeed > 0 && !queue.isEmpty()) {
                Task first = queue.poll();
                first.count -= 1;
                tmpList.add(first);
                intervalNeed--;
                count++;
            }
            for (Task task : tmpList) {
                if (task.count > 0) {
                    queue.add(task);
                }
            }

            if (queue.isEmpty()) {
                break;
            }
            count += intervalNeed;
        }
        return count;
    }

    class Task implements Comparable<Task> {
        char c;
        int count;

        public Task(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Task o) {
            return this.count != o.count ? o.count - this.count : this.c - o.c;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
