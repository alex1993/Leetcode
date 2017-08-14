package solution100_199.solution137;

/**
 * Script Created by daidai on 2017/8/10.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        //统计32位数，各个位上出现的次数，如果出现的不是3的倍数，那么最后组装起来就是结果
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        //如果某一位不能整除 3，那么那个数的这一位是 1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public int solve(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int num : nums) {
            x2 ^= (x1 & num);
            x1 ^= num;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1}));
    }
}
