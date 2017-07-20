package solution;

/**
 * Script Created by daidai on 2017/2/16.
 */
public class Solution287 {
    private final int[] flags;

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public boolean isBadVersion(int version) {
        return flags[version] == 1;
    }

    Solution287(int[] flags) {
        this.flags = flags;
    }

    public static void main(String[] args) {
        int[] flags = new int[]{0, 0, 0, 0, 1};
        Solution287 solution287 = new Solution287(flags);
        System.out.println(solution287.firstBadVersion(flags.length));
    }
}
