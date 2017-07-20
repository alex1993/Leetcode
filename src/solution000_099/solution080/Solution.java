package solution000_099.solution080;

/**
 * Script Created by daidai on 2017/6/3.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (index < 2 || num > nums[index - 2]) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,}));
    }
}
