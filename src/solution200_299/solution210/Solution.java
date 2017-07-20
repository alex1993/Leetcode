package solution200_299.solution210;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/4.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //record edge from number to List<Number>
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            res.add(first);
            if (map.containsKey(first)) {
                List<Integer> neighbours = map.get(first);
                for (Integer neighbour : neighbours) {
                    inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                    if (inDegree.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        int[] array = new int[numCourses];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }

        return res.size() == numCourses ? array : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pre = new int[][]{
            {1, 0}, {0, 1}
        };
        System.out.println(Arrays.toString(solution.findOrder(2, pre)));
    }
}
