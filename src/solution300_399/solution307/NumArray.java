package solution300_399.solution307;

/**
 * Script Created by daidai on 2017/7/4.
 */
public class NumArray {

    //BIT从 1 开始计数
    private int[] BIT;
    private int[] nums;

    public NumArray(int[] nums) {
        BIT = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    //初始化的时候，采用填坑法，例如更新总长为 18，index 11 的元素
    //11 = 1011 -- 1100 -- 10000
    private void init(int i, int val) {
        i++;
        while (i < BIT.length) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    //更新的时候需要记得把 nums[i] 也进行更新
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        init(i, delta);
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    //计算到 k 的和的时候，例如 k = 11
    //11 = 1011 --> BIT(8) + BIT(10) + BIT(11)
    //也就是每一次从最后一个 1 开始去除 1，求 BIT 的和
    //因为前 11 个元素的和，是 (1000)前 8 个 + (1001 - 1010) 9,10 个 + (1011) 第 11 个
    private int sum(int k) {
        k += 1;
        int res = 0;
        while (k > 0) {
            res += BIT[k];
            k -= (k & -k);
        }
        return res;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */