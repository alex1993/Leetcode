package solution500_599.solution565;

import java.text.ParseException;
import java.util.*;

/**
 * Script Created by daidai on 2017/5/28.
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(i)) {
                continue;
            }
            int s = i;
            List<Integer> set = new ArrayList<>();
            set.add(s);
            int curSize = 1;
            while (set.get(0) != nums[s]) {
                set.add(nums[s]);
                s = nums[s];
            }
            cache.addAll(set);
            if (set.size() > maxSize) {
                maxSize = set.size();
            }
        }
        return maxSize;

    }

    public int solve(int[] nums) {
        int size = 0;
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(i)) {
                continue;
            }
            List<Integer> res = new ArrayList<>();
            res.add(i);
            dfs(nums, res, i);
            size = Math.max(size, res.size());
            cache.addAll(res);
        }
        return size;
    }

    public void dfs(int[] nums, List<Integer> res, int index) {
        if (res.get(0) != nums[index]) {
            res.add(nums[index]);
            dfs(nums, res, nums[index]);
        }
    }

    public int dfs(int[] nums) {
        int max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            max = Math.max(max, calLength(nums, i, visited));
        }
        return max;
    }

    private int calLength(int[] nums, int start, boolean[] visited) {
        int i = start, count = 0;
        while (count == 0 || i != start) {
            visited[i] = true;
            count++;
            i = nums[i];
        }
        return count;
    }
}