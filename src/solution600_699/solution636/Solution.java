package solution600_699.solution636;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Script Created by daidai on 2017/7/16.
 */
public class Solution {
    class Pair {
        int curFunction;
        int curTime;

        Pair(int curFunction, int curTime) {
            this.curFunction = curFunction;
            this.curTime = curTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Pair> stack = new Stack<Pair>();
        int curTime = 0;
        for (int i = 0; i < logs.size(); i++) {
            String s = logs.get(i);
            String[] array = s.split(":");
            if (array[1].equals("start")) {
                int t = Integer.parseInt(array[2]);
                int curFunction = Integer.parseInt(array[0]);
                if (stack.isEmpty()) {
                    stack.push(new Pair(curFunction, t));
                } else {
                    Pair formerPair = stack.peek();
                    res[formerPair.curFunction] += t - formerPair.curTime;
                    stack.push(new Pair(curFunction, t));
                }
            } else {
                int t = Integer.parseInt(array[2]) + 1;
                int curFunction = Integer.parseInt(array[0]);
                if (stack.peek().curFunction == curFunction) {
                    res[curFunction] += t - stack.peek().curTime;
                    stack.pop();
                    if (!stack.isEmpty()) {
                        stack.peek().curTime = t;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> times = Arrays.asList(
            "0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14", "7:start:15", "1:start:24", "1:end:29",
            "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45",
            "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70",
            "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114"
        );
        System.out.println(Arrays.toString(solution.exclusiveTime(8, times)));
    }
}
