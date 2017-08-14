package solution600_699.solution657;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') {
                left++;
            } else if (c == 'R') {
                right++;
            } else if (c == 'D') {
                down++;
            } else if (c == 'U') {
                up++;
            }
        }
        return up == down && left == right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("LLRR"));
        System.out.println(solution.judgeCircle("LLR"));
        System.out.println(solution.judgeCircle("LR"));
        System.out.println(solution.judgeCircle("LL"));
        System.out.println(solution.judgeCircle(""));
    }
}
