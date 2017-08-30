package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/22.
 */
public class Slice {

    public int[] slice(int[] nums, int begin, int end, int step) {
        if (step == 0) {
            return new int[0];
        }
        if (begin < 0) {
            begin += nums.length;
        }
        if (end < 0) {
            end += nums.length;
        }

        if ((begin < 0 && end < 0) || (begin >= nums.length && end >= nums.length)) {
            return new int[0];
        }

        //如果方向不同，返回空列表
        if ((end - begin) * step < 0) {
            return new int[0];
        }

        begin = Math.max(0, Math.min(begin, nums.length - 1));
        end = Math.max(-1, Math.min(end, nums.length));

        List<Integer> res = new ArrayList<>();
        int i = begin;
        while (between(begin, end, i)) {
            res.add(nums[i]);
            i += step;
        }
        int[] tmp = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            tmp[j] = res.get(j);
        }
        return tmp;
    }

    //判断mid是否处于begin和end之间
    private boolean between(int begin, int end, int mid) {
        return (begin <= end && mid < end) || (end < mid && mid <= begin);
    }

    public static void main(String[] args) {
        Slice slice = new Slice();
        int[] res = slice.slice(new int[]{1, 2, 3, 4, 5}, 4, -1, -1);
        System.out.println(Arrays.toString(res));
    }

}
