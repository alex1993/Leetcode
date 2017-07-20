package solution500_599.solution582;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/14.
 */
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(kill);
        while (!queue.isEmpty()) {
            Integer item = queue.poll();
            res.add(item);
            if (map.containsKey(item)) {
                queue.addAll(map.get(item));
            }
        }
        return res;

    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        List<Integer> res = solution.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5);
        System.out.println(res);

        for (int i = 0; i < longCond(); i++) {
            System.out.println(i);
        }
    }

    public static int longCond() throws InterruptedException {
        Thread.sleep(1000);
        return 10;
    }

}
