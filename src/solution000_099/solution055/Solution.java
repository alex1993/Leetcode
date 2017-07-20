package solution000_099.solution055;

/**
 * Script Created by daidai on 2017/5/20.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i <= maxStep; i++) {
            if (i + nums[i] > maxStep) {
                maxStep = i + nums[i];
            }
            if (maxStep >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean can(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxStep) {
                return false;
            }
            if (i + nums[i] > maxStep) {
                maxStep = i + nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{0}));

        System.out.println(solution.can(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.can(new int[]{0, 1}));

    }
}
