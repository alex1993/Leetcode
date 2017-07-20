package solution;

/**
 * Script Created by daidai on 2017/2/16.
 */
public class Solution374 {

    private final int number;

    Solution374(int number) {
        this.number = number;
    }

    public int guessNumber(int n) {
//		return guessNumber(1, n);
        int max = n, min = 1;
        while (true) {
            int mid = min + (max - min) / 2;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            } else if (tmp == -1) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }

    public int guessNumber(int low, int high) {
        int mid = low + (high - low) / 2;
        int tmp = guess(mid);
        if (tmp == 0) {
            return mid;
        }
        if (tmp == 1) {
            return guessNumber(low, mid - 1);
        } else {
            return guessNumber(mid + 1, high);
        }
    }

    public int guess(int n) {
        if (n == number) {
            return 0;
        }
        if (n < number) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution374 solution374 = new Solution374(6);
        System.out.println(solution374.guessNumber(10));
    }
}
