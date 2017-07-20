package solution400_499.solution421;

import java.util.HashSet;
import java.util.Set;

/**
 * Script Created by daidai on 2017/4/15.
 */
public class Solution {

    class Trie {
        Trie[] next;
        Trie() {
            next = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            Trie dump = root;
            for (int i = 31; i >= 0; i--) {
                int cur = (num >> i) & 1;
                if (dump.next[cur] == null) {
                    dump.next[cur] = new Trie();
                }
                dump = dump.next[cur];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie dump = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int revBit = ((num >> i) & 1) ^ 1;
                if (dump.next[revBit] != null) {
                    curSum += (1 << i);
                    dump = dump.next[revBit];
                } else {
                    dump = dump.next[revBit ^ 1];
                }

                // for this case: even if all left bits results are 1s, curSum still cannot catch up max value
                if (curSum < max && max - curSum >= (1 << i) - 1) {
                    break;
                }
            }
            if (curSum > max) {
                max = curSum;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}