package solution500_599.solution556;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/4/9.
 */
public class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> nums = getNums(n);
        // high position with lower num
        int index = findIndex(nums);
        if (index == -1) {
            return -1;
        }

        //low position with higher num than index - 1
        int pos = nums.size() - 1;
        for (int i = nums.size() - 1; i >= index; i--) {
            if (nums.get(i) > nums.get(index - 1)) {
                pos = i;
                break;
            }
        }
        int tmp = nums.get(pos);
        nums.set(pos, nums.get(index - 1));
        nums.set(index - 1, tmp);
        nums.subList(index, nums.size()).sort(Integer::compareTo);
        return getInteger(nums);

    }

    private List<Integer> getNums(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(0, n % 10);
            n /= 10;
        }
        return nums;
    }

    private int findIndex(List<Integer> nums) {
        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums.get(i) > nums.get(i - 1)) {
                return i;
            }
        }
        return -1;
    }

    private int getInteger(List<Integer> nums) {
        int res = 0;
        int edge = (int) (Math.pow(2, 32) - 1) / 10;
        for (int i = 0; i < nums.size(); i++) {
            if (res > edge) {
                return -1;
            }
            res = res * 10 + nums.get(i);
        }
        return res;
    }

    public int solution(int n) {
        char[] chars = ("" + n).toCharArray();
        int toSwapLeft = -1;
        int i;
        for (i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                toSwapLeft = i - 1;
                break;
            }
        }
        if (toSwapLeft == -1) {
            return -1;
        }
        int toSwapRight = -1;
        for (i = chars.length - 1; i > toSwapLeft; i--) {
            if (chars[i] > chars[toSwapLeft]) {
                toSwapRight = i;
                break;
            }
        }
        char tmp = chars[toSwapLeft];
        chars[toSwapLeft] = chars[toSwapRight];
        chars[toSwapRight] = tmp;
        Arrays.sort(chars, toSwapLeft + 1, chars.length);
        long res = Long.parseLong(new String(chars));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12443322));
    }
}
