package solution000_099.solution060;

import java.util.ArrayList;
import java.util.List;

/**
 * Script Created by daidai on 2017/5/25.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }
        //fact = {1, 1, 2, 6, 24, ...}

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();

        k -= 1;
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k  = k - index * fact[n - i];
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 6));
    }
}
