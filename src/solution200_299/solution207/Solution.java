package solution200_299.solution207;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/31.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接链表，用于保存从某点出发，到达邻接所有节点的信息
        Map<Integer, List<Integer>> map = new HashMap<>();
        //入度信息，进入某个节点的点的数目
        Map<Integer, Integer> inDegree = new HashMap<>();

        //初始化，各点的链表为空
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        //填充依赖关系，入度的值加一，加入相邻边信息
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree.put(prerequisites[i][0], inDegree.getOrDefault(prerequisites[i][0], 0) + 1);
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        //先把无依赖的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            for (int i = 0; i < map.get(start).size(); i++) {
                Integer end = map.get(start).get(i);
                //入度减一
                inDegree.put(end, inDegree.get(end) - 1);
                if (inDegree.get(end) == 0) {
                    queue.add(end);
                    count++;
                }
            }
        }
        return count == numCourses;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] prev = new int[][]{{1, 0}};
        System.out.println(solution.canFinish(2, prev));
    }
}