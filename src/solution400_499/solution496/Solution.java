package solution400_499.solution496;

import java.util.*;

/**
 * Script Created by daidai on 2017/4/9.
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            int index = find(findNums[i], nums);
            res[i] = -1;
            for (int j = index + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }

    private int find(int findNum, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == findNum) {
                return i;
            }
        }
        return -1;
    }

    public int[] solution(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            while (stack.size() != 0 && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
