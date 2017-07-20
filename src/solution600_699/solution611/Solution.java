package solution600_699.solution611;

import java.util.Arrays;

/**
 * Script Created by daidai on 2017/6/11.
 */
public class Solution {

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    total += (k - j);
                    k--;
                } else {
                    j++;
                }
            }
        }
        return total;
    }

    //e: inclusive
    //lowerBound 意思是找到第一个 >= key 的index
    private int lowerBound(int[] nums, int s, int e, int key) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] >= key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    //upper bound 与 lower bound 之间的区别就在于 = 号
    //upperBound 意思是找到第一个 > key 的index
    private int upperBound(int[] nums, int s, int e, int key) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    //e: exclusive
    int lowerBound0(int[] nums, int s, int e, int key) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] >= key) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(solution.lowerBound(new int[]{2, 3, 3, 4, 6, 7}, 0, 5, 4));
        System.out.println(solution.lowerBound0(new int[]{2, 3, 3, 4, 6, 7}, 0, 6, 4));
    }
}
