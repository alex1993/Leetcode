package solution300_399.solution399;

import java.util.*;

/**
 * Script Created by daidai on 2017/6/5.
 */
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            for (int j = 0; j < equations[i].length; j++) {
                String from = equations[i][0];
                String to = equations[i][1];
                map.putIfAbsent(from, new ArrayList<>());
                map.putIfAbsent(to, new ArrayList<>());
                Edge edgeFrom = new Edge(to, values[i]);
                Edge edgeTo = new Edge(from, 1 / values[i]);
                map.get(from).add(edgeFrom);
                map.get(to).add(edgeTo);
            }
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0])) {
                res[i] = -1;
                continue;
            }
            Set<String> visited = new HashSet<>();
            dfs(map, visited, queries[i][0], queries[i][1], 1.0, i, res);
            if (res[i] == 0 && !Objects.equals(queries[i][0], queries[i][1])) {
                res[i] = -1;
            }
        }
        return res;
    }

    private void dfs(Map<String, List<Edge>> map, Set<String> visited, String s, String e, double distance, int i, double[] res) {
        if (s.equals(e)) {
            res[i] = distance;
        }
        if (visited.contains(s)) {
            return;
        }
        visited.add(s);
        if (!map.containsKey(s) || !map.containsKey(e)) {
            res[i] = -1;
            return;
        }
        List<Edge> adjs = map.get(s);
        for (Edge adj : adjs) {
            dfs(map, visited, adj.to, e, distance * adj.weight, i, res);
        }

    }

    class Edge {
        String to;
        double weight;

        public Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.calcEquation(
            new String[][]{{"a", "b"}, {"c", "d"}},
            new double[]{1.0, 1.0},
            new String[][]{{"a", "c"}, {"b", "d"}, {"b", "a"}, {"d", "c"}}
        )));
    }

}
