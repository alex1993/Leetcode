package solution400_499.solution464;

import java.util.HashMap;
import java.util.Map;

/**
 * Script Created by daidai on 2017/8/5.
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (total < desiredTotal) {
            return false;
        }
        return sum(desiredTotal, new boolean[maxChoosableInteger + 1], new HashMap<>());
    }

    //cache 用来保存某个序列的的结果，key是使用了的数字的hash值
    //cache中只需要保存剩下的序列就好，因为这个序列已经能体现初剩下的desiredTotal
    //used[i]用于记录那些数字已经使用过了
    private boolean sum(int desiredTotal, boolean[] used, Map<Integer, Boolean> cache) {
        int hash = arrayToInt(used);
        if (cache.containsKey(hash)) {
            return cache.get(hash);
        }

        for (int i = 1; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            //如果当前可以选的值已经比desired更大，或者选择了这个值之后对方会输，那么返回true
            //并且更新cache
            if (i >= desiredTotal || !sum(desiredTotal - i, used, cache)) {
                used[i] = false;
                cache.put(hash, true);
                return true;
            }
            used[i] = false;
        }
        cache.put(hash, false);
        return false;
    }

    private int arrayToInt(boolean[] used) {
        int res = 0;
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                res |= (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canIWin(10, 11));
    }
}
