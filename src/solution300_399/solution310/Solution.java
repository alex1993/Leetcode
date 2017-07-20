package solution300_399.solution310;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/4.
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //from vertex to vertex and vice versa
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int ver1 = edges[i][0];
            int ver2 = edges[i][1];
            map.putIfAbsent(ver1, new ArrayList<>());
            map.putIfAbsent(ver2, new ArrayList<>());
            map.get(ver1).add(ver2);
            map.get(ver2).add(ver1);
        }

        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int level = bfsLevel(map, i);
            if (level < minHeight) {
                res = new ArrayList<>();
                res.add(i);
                minHeight = level;
            } else if (level == minHeight) {
                res.add(i);
            }
        }

        return res;

    }

    private int bfsLevel(Map<Integer, List<Integer>> map, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int level = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Integer first = queue.poll();
                if (visited.contains(first)) {
                    continue;
                }
                if (map.containsKey(first)) {
                    queue.addAll(map.get(first));
                }
                visited.add(first);
            }
        }

        return level;
    }

    private List<Integer> findMinHeights(int n, int[][] edges) {
        //from vertex to vertex and vice versa
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int ver1 = edges[i][0];
            int ver2 = edges[i][1];
            map.putIfAbsent(ver1, new ArrayList<>());
            map.putIfAbsent(ver2, new ArrayList<>());
            map.get(ver1).add(ver2);
            map.get(ver2).add(ver1);
        }

        Map<Integer, Integer> dist = new HashMap<>();
        bfs(map, 0, dist, new HashMap<>());
        int s = 0;
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            if (dist.get(s) < dist.get(entry.getKey())) {
                s = entry.getKey();
            }
        }

        Map<Integer, Integer> dist2 = new HashMap<>();
        Map<Integer, Integer> pre = new HashMap<>();
        bfs(map, s, dist2, pre);
        int v = 0;
        for (Map.Entry<Integer, Integer> entry : dist2.entrySet()) {
            if (dist2.get(v) < dist2.get(entry.getKey())) {
                v = entry.getKey();
            }
        }

        List<Integer> list = new ArrayList<>();
        while (v != -1) {
            list.add(v);
            v = pre.get(v);
        }

        if (list.size() % 2 == 1) {
            return Collections.singletonList(list.get(list.size() / 2));
        } else {
            return Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));
        }
    }

    private void bfs(Map<Integer, List<Integer>> map, int s, Map<Integer, Integer> level, Map<Integer, Integer> pre) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        Set<Integer> visited = new HashSet<>();
        visited.add(s);

        level.put(s, 0);
        pre.put(s, -1);

        while (!queue.isEmpty()) {
            Integer first = queue.poll();

            if (map.containsKey(first)) {
                List<Integer> neighbours = map.get(first);
                for (Integer neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(first);
                        queue.add(neighbour);
                        level.put(neighbour, level.get(first) + 1);
                        pre.put(neighbour, first);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinHeights(1, new int[][]{}));
    }
}
