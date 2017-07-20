package solution100_199.solution133;

import java.util.*;

/**
 * Script Created by daidai on 2017/5/31.
 */
//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);

        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(root.label, root);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(head.label).neighbors.add(map.get(neighbor.label));
            }
        }

        return root;
    }

    public UndirectedGraphNode solve(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return helper(node, new HashMap<>());
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(cloned.label, cloned);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (map.containsKey(neighbor.label)) {
                cloned.neighbors.add(map.get(neighbor.label));
            } else {
                cloned.neighbors.add(helper(neighbor, map));
            }
        }
        return cloned;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        node0.neighbors.add(node0);
        node0.neighbors.add(node0);
        node0.neighbors.add(node0);

        System.out.println(solution.cloneGraph(node0));
    }
}
