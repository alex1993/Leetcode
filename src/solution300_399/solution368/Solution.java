package solution300_399.solution368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        //count 表示以 nums[i]结尾的subset的最大长度
        int[] count = new int[n];
        //prev 表示 nums[i] 的前驱节点
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    //只有当把 num[j] 和 nums[i] 计算进去，比之前的结果更大的时候才更新
                    //count[i] 和 prev[i]，这是为了保留更小的那个 nums[j]
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestDivisibleSubset(new int[]{}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
