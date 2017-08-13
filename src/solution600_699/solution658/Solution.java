package solution600_699.solution658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Script Created by daidai on 2017/8/13.
 */
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }
        if (k >= arr.size()) {
            return arr;
        }
        int bound = lowerBound(arr, x);
        if (bound - 1 >= 0 && x - arr.get(bound - 1) < arr.get(bound) - x) {
            bound--;
        }
        int low = bound - 1;
        int high = bound + 1;

        List<Integer> res = new ArrayList<>();
        res.add(arr.get(bound));
        int count = 1;
        while (low >= 0 && high < arr.size() && count < k) {
            int left = x - arr.get(low);
            int right = arr.get(high) - x;
            if (left <= right) {
                res.add(arr.get(low));
                low--;
            } else {
                res.add(arr.get(high));
                high++;
            }
            count++;
        }

        while (low >= 0 && count < k) {
            res.add(arr.get(low--));
            count++;
        }
        while (high < arr.size() && count < k) {
            res.add(arr.get(high++));
            count++;
        }
        Collections.sort(res);
        return res;
    }

    private int lowerBound(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosestElements(Arrays.asList(0, 0, 1, 2, 3, 3, 4, 7, 7, 8), 3, 5));
    }
}
