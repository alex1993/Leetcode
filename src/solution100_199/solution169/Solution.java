package solution100_199.solution169;

/**
 * Script Created by daidai on 2017/6/13.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //发现相同元素，个数 + 1
            if (nums[i] == res) {
                count++;
            } else if (count > 0) {
                //不同元素，则消除一个
                count = count - 1;
            } else {
                //当前边的元素都消除了，那么开始新的计数
                count = 0;
                res = nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{1, 1, 2, 2, 2}));
    }
}
