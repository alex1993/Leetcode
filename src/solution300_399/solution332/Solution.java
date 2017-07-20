package solution300_399.solution332;

import java.util.*;

/**
 * Script Created by daidai on 2017/7/1.
 */
public class Solution {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        List<String> res = new LinkedList<>();
        dfs(map, res, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String start) {
        PriorityQueue<String> queue = map.get(start);
        while (queue != null && !queue.isEmpty()) {
            dfs(map, res, queue.poll());
        }
        res.add(0, start);
    }

    public List<String> solve(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        Stack<String> stack = new Stack<>();
        List<String> res = new LinkedList<>();

        stack.push("JFK");
        String cur = stack.peek();
        while (!stack.isEmpty()) {
            if (map.containsKey(cur)) {
                stack.push(cur);
                String next = map.get(cur).poll();
                if (map.get(cur).isEmpty()) {
                    map.remove(cur);
                }
                cur = next;
            } else {
                res.add(0, cur);
                cur = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
    }

}
