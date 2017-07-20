package solution200_299.solution275;

/**
 * Script Created by daidai on 2017/6/26.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1;
        int len = citations.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == len - mid) {
                return citations[mid];
            } else if (citations[mid] > len - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return len - (high + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[]{0, 0, 4, 4}));
    }
}
