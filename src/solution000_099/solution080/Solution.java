package solution000_099.solution080;

/**
 * Script Created by daidai on 2017/8/11.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[count - 2]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3, 3}));
    }
}
