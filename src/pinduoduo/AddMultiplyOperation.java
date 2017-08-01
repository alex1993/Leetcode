package pinduoduo;

/**
 * Script Created by daidai on 2017/7/21.
 */
public class AddMultiplyOperation {
    public int addAndMultiply(int[] a, int[] b) {
        int n = a.length;
        int addCount = 0;
        int multiplyCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return -1;
            }
            if (a[i] == b[i]) {
                continue;
            }
            if (a[i] == 0) {
                addCount++;
                a[i]++;
            }
            int mCount = 0;
            while (2 * a[i] <= b[i]) {
                mCount++;
                a[i] *= 2;
            }
            addCount += (b[i] - a[i]);
            multiplyCount = Math.max(multiplyCount, mCount);
        }
        return addCount + multiplyCount;
    }

    public static void main(String[] args) {
        AddMultiplyOperation addMultiplyOperation = new AddMultiplyOperation();
        int i = addMultiplyOperation.addAndMultiply(new int[]{1, 2, 4, 5, 10}, new int[]{2, 3, 5, 6, 10});
        System.out.println(i);
    }
}
