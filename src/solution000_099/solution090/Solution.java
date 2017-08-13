package solution000_099.solution090;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Script Created by daidai on 2017/8/8.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int level, int[] nums) {
        res.add(new ArrayList<>(prefix));
        for (int i = level; i < nums.length; i++) {
            if (i > level && nums[i] == nums[i - 1]) {
                continue;
            }
            prefix.add(nums[i]);
            backTracking(res, prefix, i + 1, nums);
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
