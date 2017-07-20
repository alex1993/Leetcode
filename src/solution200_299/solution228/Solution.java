package solution200_299.solution228;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/24.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int count = 0;
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
                count++;
            }
            if (count > 0) {
                sb.append("->");
                sb.append(nums[i]);
            }
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 2}));
    }
}
