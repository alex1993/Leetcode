package solution000_099.solution041;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //想要找到第一个缺失的正数，对于一个介于 [1, k] 的数组，缺失的值为 [1, k + 1]
    //但是因为有负数，所以问题有点复杂，可以将这些整数填到相应的位置上，例如 0 -> 1, 1 -> 2
    //即在位置 i 填充的是 i + 1, 那么遍历的时候第一个 nums[i] != i + 1 的就是结果
    //所以碰到一个数，发现 nums[i] != i + 1（目的位置）的值和 nums[i] 不同，那么就需要交换值，
    //需要把当前第 i 个和 nums[i] - 1 个（因为这才是 nums[i]需要待的位置）位置的数做交换
    //当然如果当前值是负数，或者过大（超过length），那么就保持在当前位置
    public int solve(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                //如果是正确位置，负数或者值过大，那么就直接跳到下一个数
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                //发现当前位置的正数放在了错误的位置，并且目标位置的值也不对（重要，否则会死循环），和正确的位置的值暂时做交换
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 1}));
    }
}
