package solution200_299.solution241;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/21.
 */
public class Solution {
    // 穷举所有方法，要么就是搜索问题，要么就是divide and conquer，一定要把问题简单化
    // 化成简单的子问题
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        char[] charArray = input.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1, charArrayLength);
                List<Integer> leftList = diffWaysToCompute(left);
                List<Integer> rightList = diffWaysToCompute(right);
                for (Integer num1 : leftList) {
                    for (Integer num2 : rightList) {
                        if (c == '+') {
                            res.add(num1 + num2);
                        }
                        if (c == '-') {
                            res.add(num1 - num2);
                        }
                        if (c == '*') {
                            res.add(num1 * num2);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1"));
    }
}
