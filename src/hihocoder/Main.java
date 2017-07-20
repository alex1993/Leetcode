package hihocoder;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Task> tasks = new ArrayList<>();
        int taskCount = scanner.nextInt();
        for (int i = 0; i < taskCount; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            tasks.add(new Task(s, e));
        }
        Collections.sort(tasks);

        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < tasks.size(); i++) {
            while (!ends.isEmpty() && ends.peek() <= tasks.get(i).s) {
                ends.poll();
            }
            ends.add(tasks.get(i).e);
            max = Math.max(ends.size(), max);
        }
        System.out.println(max);
    }

    static class Task implements Comparable<Task> {
        int s;
        int e;
        Task(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Task{" +
                       "s=" + s +
                       ", e=" + e +
                       '}';
        }

        @Override
        public int compareTo(Task o) {
            return this.s - o.s;
        }
    }
}
