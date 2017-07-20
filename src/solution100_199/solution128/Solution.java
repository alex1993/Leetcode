package solution100_199.solution128;

import java.util.*;

/**
 * Script Created by daidai on 2017/4/18.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] resNum = new int[set.size()];
        int j = 0;
        for (int num : set) {
            resNum[j] = num;
            j++;
        }

        int maxNum = 0;
        for (int i = 0; i < resNum.length; i++) {
            int count = 1;
            while (i < resNum.length - 1 && resNum[i + 1] - resNum[i] == 1) {
                count++;
                i++;
            }
            if (count > maxNum) {
                maxNum = count;
            }
        }

        return maxNum;

    }

    public int solve(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int maxCount = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                unionFind.union(map.get(num), map.get(num - 1));
            }
            if (map.containsKey(num + 1)) {
                unionFind.union(map.get(num), map.get(num + 1));
            }
        }
        for (int size : unionFind.unionSize) {
            if (size > maxCount) {
                maxCount = size;
            }
        }
        return maxCount;
    }

    class UnionFind {
        int[] father;
        int[] unionSize;

        UnionFind(int[] nums) {
            father = new int[nums.length];
            unionSize = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                father[i] = i;
                unionSize[i] = 1;
            }
        }

        int find(int node) {
            if (father[node] == node) {
                return node;
            }
            father[node] = find(father[node]);
            return father[node];
        }

        void union(int node1, int node2) {
            int find1 = find(node1);
            int find2 = find(node2);
            if (find1 != find2) {
                father[find1] = find2;
                int size = unionSize[find1] + unionSize[find2];
                unionSize[find1] = size;
                unionSize[find2] = size;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{0, -1, 0}));
    }
}
