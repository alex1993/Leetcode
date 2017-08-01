package solution300_399.solution330;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/27.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long missing = 1;
        int i = 0;
        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i];
                i++;
            } else {
                count++;
                missing += missing;
            }
        }
        return count;
    }

    private void totalCombination(List<Integer> previous) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= previous.size(); i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            combination(previous, new ArrayList<>(), tmp, new boolean[previous.size()], i, 0);
            res.addAll(tmp);
        }
        System.out.println(res);
    }

    private void combination(List<Integer> previous, List<Integer> prefix, List<List<Integer>> curComb, boolean[] used, int target, int depth) {
        if (prefix.size() == target) {
            curComb.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < previous.size(); i++) {
            if (used[i]) {
                continue;
            }
            prefix.add(previous.get(i));
            used[i] = true;
            combination(previous, prefix, curComb, used, target, depth + 1);
            used[i] = false;
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
