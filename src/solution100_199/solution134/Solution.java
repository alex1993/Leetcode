package solution100_199.solution134;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/6/15.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int s = 0;
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < cost.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                s = i + 1;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));

    }
}
