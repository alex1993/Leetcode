package solution300_399.solution315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Script Created by daidai on 2017/7/2.
 */
public class Solution {
    //和 length longest increasing sub sequence 不一样
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        //因为需要记录原始数组中比当前位置小的元素个数，需要记录原始位置在哪
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        int[] counts = new int[nums.length];
        divideConquer(nums, 0, nums.length - 1, counts, indexes);
        List<Integer> res = new ArrayList<>();
        for (int count : counts) {
            res.add(count);
        }
        return res;
    }

    private void divideConquer(int[] nums, int s, int e, int[] counts, int[] indexes) {
        if (s == e) {
            return;
        }
        int mid = s + (e - s) / 2;
        divideConquer(nums, s, mid, counts, indexes);
        divideConquer(nums, mid + 1, e, counts, indexes);
        merge(nums, s, mid, mid + 1, e, counts, indexes);
    }

    private void merge(int[] nums, int s1, int e1, int s2, int e2, int[] counts, int[] indexes) {
        //使用临时表来存储新的索引的顺序
        int len = e1 - s1 + 1 + e2 - s2 + 1;
        int[] newIndexes = new int[len];

        //i, j 分别用于记录 indexes 的指针
        int i = s1, j = s2;
        int k = 0;
        int rightCount = 0;
        while (i <= e1 && j <= e2) {
            if (nums[indexes[i]] <= nums[indexes[j]]) {
                //当前数的逆序对的个数，是目前位置的逆序对 + 右边的逆序的个数
                counts[indexes[i]] += rightCount;
                newIndexes[k++] = indexes[i++];
            } else {
                //当右边的数更小时，计数 +1
                rightCount++;
                newIndexes[k++] = indexes[j++];
            }
        }

        while (i <= e1) {
            counts[indexes[i]] += rightCount;
            newIndexes[k++] = indexes[i++];
        }

        while (j <= e2) {
            newIndexes[k++] = indexes[j++];
        }

        for (int m = 0, n = s1; m < newIndexes.length; m++, n++) {
            indexes[n] = newIndexes[m];
        }
    }

    private List<Integer> solve(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = lowerBound(sorted, nums[i]);
            sorted.add(index, nums[i]);
            counts[i] = index;
        }
        return Arrays.asList(counts);
    }

    private int lowerBound(List<Integer> sorted, int num) {
        int low = 0, high = sorted.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted.get(mid) >= num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    class TreeNode {
        int smallCount;
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int count, int val) {
            this.smallCount = count;
            this.val = val;
        }
    }

    public List<Integer> bst(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        TreeNode root = null;
        Integer[] ret = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], ret, i, 0);
        }
        return Arrays.asList(ret);
    }

    public TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int preSum) {
        if (root == null) {
            root = new TreeNode(0, val);
            ans[index] = preSum;
        } else if (root.val > val) {
            root.smallCount++;
            root.left = insert(root.left, val, ans, index, preSum);
        } else {
            //only adding 1 on preSum if root.val is only smaller than val
            root.right = insert(root.right, val, ans, index, root.smallCount + preSum + (root.val < val ? 1 : 0));
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(new int[]{-1, -1}));
    }
}