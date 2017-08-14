package solution000_099.solutoin089;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | 1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(5));
    }
}
